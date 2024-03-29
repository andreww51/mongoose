package mongoose.ecommerce.frontoffice.operations.cart;

import mongoose.ecommerce.frontoffice.activities.cart.routing.CartRouting;
import dev.webfx.framework.client.operations.route.RoutePushRequest;
import dev.webfx.platform.shared.services.json.Json;
import dev.webfx.platform.client.services.windowhistory.spi.BrowsingHistory;

import java.time.Instant;

/**
 * @author Bruno Salmon
 */
public final class RouteToCartRequest extends RoutePushRequest {

    public RouteToCartRequest(Object cartUuidOrDocument, BrowsingHistory history) {
        super(CartRouting.getCartPath(cartUuidOrDocument), history, Json.createObject().set("refresh", Instant.now()));
    }

}
