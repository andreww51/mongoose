package mongoose.event.backoffice.activities.options;

import mongoose.event.frontoffice.activities.options.routing.OptionsRouting;
import dev.webfx.framework.client.activity.impl.combinations.viewdomain.impl.ViewDomainActivityContextFinal;
import dev.webfx.framework.client.ui.uirouter.UiRoute;
import dev.webfx.framework.client.ui.uirouter.impl.UiRouteImpl;

/**
 * @author Bruno Salmon
 */
public final class EditableOptionsUiRoute extends UiRouteImpl<ViewDomainActivityContextFinal> {

    public EditableOptionsUiRoute() {
        super(uiRoute());
    }

    public static UiRoute<ViewDomainActivityContextFinal> uiRoute() {
        return UiRoute.create(OptionsRouting.getPath()
                , false
                , EditableOptionsActivity::new
                , ViewDomainActivityContextFinal::new
        );
    }

}
