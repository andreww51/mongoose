package mongoose.base.shared.entities.markers;

import dev.webfx.framework.shared.orm.entity.Entity;

/**
 * @author Bruno Salmon
 */
public interface EntityHasCode extends Entity, HasCode {

    @Override
    default void setCode(String code) {
        setFieldValue("code", code);
    }

    @Override
    default String getCode() {
        return getStringFieldValue("code");
    }
}
