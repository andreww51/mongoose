package mongoose.crm.backoffice.activities.users;

import javafx.scene.Node;
import mongoose.base.backoffice.controls.masterslave.ConventionalUiBuilder;
import mongoose.base.backoffice.controls.masterslave.ConventionalUiBuilderMixin;
import mongoose.base.client.activity.eventdependent.EventDependentViewDomainActivity;
import mongoose.base.shared.domainmodel.functions.AbcNames;
import mongoose.base.shared.entities.Person;
import dev.webfx.framework.client.orm.reactive.mapping.entities_to_visual.ReactiveVisualMapper;

import static dev.webfx.framework.shared.orm.dql.DqlStatement.where;

final class UsersActivity extends EventDependentViewDomainActivity implements
        ConventionalUiBuilderMixin {

    /*==================================================================================================================
    ================================================= Graphical layer ==================================================
    ==================================================================================================================*/

    private final UsersPresentationModel pm = new UsersPresentationModel();

    @Override
    public UsersPresentationModel getPresentationModel() {
        return pm; // eventId and organizationId will then be updated from route
    }

    private ConventionalUiBuilder ui; // Keeping this reference for activity resume

    @Override
    public Node buildUi() {
        ui = createAndBindGroupMasterSlaveViewWithFilterSearchBar(pm, "users", "Person");
        return ui.buildUi();
    }

    @Override
    public void onResume() {
        super.onResume();
        ui.onResume();
    }


    /*==================================================================================================================
    =================================================== Logical layer ==================================================
    ==================================================================================================================*/

    private ReactiveVisualMapper<Person> groupVisualMapper, masterVisualMapper;

    @Override
    protected void startLogic() {
        // Setting up the group mapper that build the content displayed in the group view
        groupVisualMapper = ReactiveVisualMapper.<Person>createGroupReactiveChain(this, pm)
                .always("{class: 'Person', alias: 'p', orderBy: 'id'}")
                .start();

        // Setting up the master mapper that build the content displayed in the master view
        masterVisualMapper = ReactiveVisualMapper.<Person>createMasterPushReactiveChain(this, pm)
                .always("{class: 'Person', alias: 'p', orderBy: 'lastName,firstName,id'}")
                // Applying the user search
                .ifTrimNotEmpty(pm.searchTextProperty(), s ->
                        s.contains("@") ? where("lower(email) like ?", "%" + s.toLowerCase() + "%")
                                : where("abcNames(firstName + ' ' + lastName) like ?", AbcNames.evaluate(s, true)))
                .applyDomainModelRowStyle() // Colorizing the rows
                .start();
    }

    @Override
    protected void refreshDataOnActive() {
        groupVisualMapper.refreshWhenActive();
        masterVisualMapper.refreshWhenActive();
    }
}
