package mongoose.base.client.aggregates.person;

import mongoose.base.shared.entities.Person;
import dev.webfx.framework.shared.orm.entity.EntityStore;

/**
 * @author Bruno Salmon
 */
public interface PersonAggregate {

    static PersonAggregate get(EntityStore store) {
        return PersonAggregateImpl.get(store);
    }

    static PersonAggregate getOrCreate(EntityStore store) {
        return PersonAggregateImpl.getOrCreate(store);
    }

    Person getPreselectionProfilePerson();

}
