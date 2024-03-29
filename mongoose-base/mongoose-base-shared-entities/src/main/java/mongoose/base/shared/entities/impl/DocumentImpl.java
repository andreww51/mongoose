package mongoose.base.shared.entities.impl;

import mongoose.base.shared.entities.Document;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.framework.shared.orm.entity.EntityStore;
import dev.webfx.framework.shared.orm.entity.impl.DynamicEntity;
import dev.webfx.framework.shared.orm.entity.impl.EntityFactoryProviderImpl;

/**
 * @author Bruno Salmon
 */
public final class DocumentImpl extends DynamicEntity implements Document {

    public DocumentImpl(EntityId id, EntityStore store) {
        super(id, store);
    }

    public static final class ProvidedFactory extends EntityFactoryProviderImpl<Document> {
        public ProvidedFactory() {
            super(Document.class, DocumentImpl::new);
        }
    }
}
