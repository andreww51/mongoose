package mongoose.ecommerce.backoffice.operations.entities.moneyflow;

import dev.webfx.framework.client.ui.controls.dialog.DialogContent;
import dev.webfx.framework.client.ui.controls.dialog.DialogUtil;
import dev.webfx.framework.shared.orm.entity.UpdateStore;
import dev.webfx.platform.shared.services.submit.SubmitArgument;
import dev.webfx.platform.shared.async.Future;
import javafx.scene.layout.Pane;
import mongoose.base.shared.entities.MoneyFlow;

final class DeleteMoneyFlowExecutor {

    static Future<Void> executeRequest(DeleteMoneyFlowRequest rq) {
        return execute(rq.getMoneyFlow(), rq.getParentContainer());
    }

    private static Future<Void> execute(MoneyFlow deleteEntity, Pane parentContainer) {
        if (deleteEntity != null) {
            String msg = "Delete money flow from " + deleteEntity.getFromMoneyAccount().getName() + " to " + deleteEntity.getToMoneyAccount().getName() + "?";
            DialogContent dialogContent = new DialogContent().setTitle("Confirm money flow deletion").setContentText(msg);
            DialogUtil.showModalNodeInGoldLayout(dialogContent, parentContainer);
            DialogUtil.armDialogContentButtons(dialogContent, dialogCallback -> {
                deleteMoneyFlow(deleteEntity);
                dialogCallback.closeDialog();
            });
        }
        return Future.succeededFuture();
    }

    private static void deleteMoneyFlow(MoneyFlow deleteEntity) {
        UpdateStore updateStore = UpdateStore.createAbove(deleteEntity.getStore());
        updateStore.deleteEntity(deleteEntity);
        updateStore.submitChanges(SubmitArgument.builder()
                .setStatement("select set_transaction_parameters(false)")
                .setDataSourceId(updateStore.getDataSourceId())
                .build());
    }
}