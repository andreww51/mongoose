package mongoose.base.shared.entities.markers;

import mongoose.base.shared.entities.Person;
import dev.webfx.framework.shared.orm.entity.Entity;
import dev.webfx.framework.shared.orm.entity.EntityId;

/**
 * @author Bruno Salmon
 */
public interface EntityHasPerson extends Entity, HasPerson {

    @Override
    default void setPerson(Object person) {
        setForeignField("person", person);
    }

    @Override
    default EntityId getPersonId() {
        return getForeignEntityId("person");
    }

    @Override
    default Person getPerson() {
        return getForeignEntity("person");
    }

}
