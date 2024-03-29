package mongoose.base.shared.entities.impl;

import mongoose.base.shared.entities.Person;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.framework.shared.orm.entity.EntityStore;
import dev.webfx.framework.shared.orm.entity.impl.DynamicEntity;
import dev.webfx.framework.shared.orm.entity.impl.EntityFactoryProviderImpl;

/**
 * @author Bruno Salmon
 */
public final class PersonImpl extends DynamicEntity implements Person {

    public PersonImpl(EntityId id, EntityStore store) {
        super(id, store);
    }

    public static final class ProvidedFactory extends EntityFactoryProviderImpl<Person> {
        public ProvidedFactory() {
            super(Person.class, PersonImpl::new);
        }
    }
}
