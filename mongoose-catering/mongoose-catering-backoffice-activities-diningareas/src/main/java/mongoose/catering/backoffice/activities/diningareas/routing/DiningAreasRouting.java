package mongoose.catering.backoffice.activities.diningareas.routing;

import mongoose.base.client.util.routing.MongooseRoutingUtil;

/**
 * @author Bruno Salmon
 */
public final class DiningAreasRouting {

    private final static String PATH = "/dining-areas/event/:eventId";

    public static String getPath() {
        return PATH;
    }

    public static String getEventPath(Object eventId) {
        return MongooseRoutingUtil.interpolateEventIdInPath(eventId, PATH);
    }

}
