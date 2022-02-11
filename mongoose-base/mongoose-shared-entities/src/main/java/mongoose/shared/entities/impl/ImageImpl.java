package mongoose.shared.entities.impl;

import mongoose.shared.entities.Image;
import dev.webfx.framework.shared.orm.entity.EntityId;
import dev.webfx.framework.shared.orm.entity.EntityStore;
import dev.webfx.framework.shared.orm.entity.impl.DynamicEntity;
import dev.webfx.framework.shared.orm.entity.impl.EntityFactoryProviderImpl;

/**
 * @author Bruno Salmon
 */
public final class ImageImpl extends DynamicEntity implements Image {

    public ImageImpl(EntityId id, EntityStore store) {
        super(id, store);
    }

    public static final class ProvidedFactory extends EntityFactoryProviderImpl<Image> {
        public ProvidedFactory() {
            super(Image.class, ImageImpl::new);
        }
    }
}