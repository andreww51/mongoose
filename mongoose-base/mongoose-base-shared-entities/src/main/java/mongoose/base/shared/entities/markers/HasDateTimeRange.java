package mongoose.base.shared.entities.markers;

import mongoose.hotel.shared.businessdata.time.DateTimeRange;

/**
 * @author Bruno Salmon
 */
public interface HasDateTimeRange {

    void setDateTimeRange(String dateTimeRange);

    String getDateTimeRange();

    default DateTimeRange getParsedDateTimeRange() { // Should be overridden by implementing class to have a cached value
        return DateTimeRange.parse(getDateTimeRange());
    }

}
