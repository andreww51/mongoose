package mongoose.ecommerce.client.businessdata.workingdocument;

import mongoose.base.client.aggregates.cart.CartAggregate;
import mongoose.base.client.aggregates.cart.CartAggregateImpl;
import mongoose.base.client.aggregates.event.EventAggregate;
import mongoose.base.shared.entities.Cart;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.platform.shared.util.collection.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class WorkingDocumentsByCartStore {

    private final static Map<EntityId, List<WorkingDocument>> workingDocumentsByCartMap = new HashMap<>();

    public static List<WorkingDocument> getCartWorkingDocuments(CartAggregate cartAggregate) {
        return getCartWorkingDocuments(cartAggregate.getCart());
    }

    public static List<WorkingDocument> getCartWorkingDocuments(Cart cart) {
        return getCartWorkingDocuments(cart.getId());
    }

    public static List<WorkingDocument> getCartWorkingDocuments(EntityId cartId) {
        List<WorkingDocument> workingDocuments = workingDocumentsByCartMap.get(cartId);
        if (workingDocuments == null) {
            CartAggregateImpl cartAggregate = (CartAggregateImpl) CartAggregate.get(cartId);
            EventAggregate eventAggregate = cartAggregate.getEventAggregate();
            workingDocuments = Collections.map(cartAggregate.getCartDocuments(), document ->
                new WorkingDocument(new WorkingDocument(eventAggregate, document,
                        Collections.map(Collections.filter(cartAggregate.getCartDocumentLines(), dl -> dl.getDocument() == document), documentLine ->
                            new WorkingDocumentLine(documentLine, Collections.filter(cartAggregate.getCartAttendances(), a -> a.getDocumentLine() == documentLine), eventAggregate)
                        )
                ))
            );
            workingDocumentsByCartMap.put(cartId, workingDocuments);
        }
        return workingDocuments;
    }

    public static void unloadCartWorkingDocuments(Cart cart) {
        unloadCartWorkingDocuments(cart.getId());
    }

    public static void unloadCartWorkingDocuments(EntityId cartId) {
        workingDocumentsByCartMap.remove(cartId);
    }
}
