package mongoose.base.shared.entities;

import dev.webfx.framework.shared.orm.entity.Entity;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.platform.shared.util.Objects;
import mongoose.base.shared.entities.markers.*;
import mongoose.hotel.shared.businessdata.time.DateTimeRange;

import java.time.LocalDate;

/**
 * @author Bruno Salmon
 */
public interface Event extends Entity,
        EntityHasName,
        EntityHasLabel,
        EntityHasIcon,
        EntityHasOrganization,
        EntityHasDateTimeRange,
        EntityHasMinDateTimeRange,
        EntityHasMaxDateTimeRange {

    default LocalDate getStartDate() {
        return getLocalDateFieldValue("startDate");
    }

    default LocalDate getEndDate() {
        return getLocalDateFieldValue("endDate");
    }

    default void setLive(Boolean live) {
        setFieldValue("live", live);
    }

    default Boolean isLive() {
        return getBooleanFieldValue("live");
    }

    default void setFeesBottomLabel(Object label) {
        setForeignField("feesBottomLabel", label);
    }

    default EntityId getFeesBottomLabelId() {
        return getForeignEntityId("feesBottomLabel");
    }

    default Label getFeesBottomLabel() {
        return getForeignEntity("feesBottomLabel");
    }

    default DateTimeRange computeMaxDateTimeRange() {
        return Objects.coalesce(getParsedMaxDateTimeRange(), getParsedDateTimeRange());
    }


}
