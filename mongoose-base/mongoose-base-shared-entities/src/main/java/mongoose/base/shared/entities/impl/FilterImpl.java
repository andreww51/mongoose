package mongoose.base.shared.entities.impl;

import mongoose.base.shared.entities.Filter;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.framework.shared.orm.entity.EntityStore;
import dev.webfx.framework.shared.orm.entity.impl.DynamicEntity;
import dev.webfx.framework.shared.orm.entity.impl.EntityFactoryProviderImpl;

/**
 * @author Bruno Salmon
 */
public final class FilterImpl extends DynamicEntity implements Filter {

    public FilterImpl(EntityId id, EntityStore store) {
        super(id, store);
    }

    public static final class ProvidedFactory extends EntityFactoryProviderImpl<Filter> {
        public ProvidedFactory() {
            super(Filter.class, FilterImpl::new);
        }
    }
}
