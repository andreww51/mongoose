package mongoose.ecommerce.backoffice.operations.entities.document.registration;

import javafx.scene.layout.Pane;
import mongoose.base.backoffice.operations.entities.generic.SetEntityFieldRequest;
import mongoose.base.shared.entities.Document;

public final class MarkDocumentPassAsUpdatedRequest extends SetEntityFieldRequest {

    private final static String OPERATION_CODE = "MarkDocumentPassAsUpdated";

    public MarkDocumentPassAsUpdatedRequest(Document document, Pane parentContainer) {
        super(document, "read", "true", null, parentContainer);
    }

    @Override
    public Object getOperationCode() {
        return OPERATION_CODE;
    }
}
