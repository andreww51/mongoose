// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.base.shared.domainmodel {

    // Direct dependencies modules
    requires java.base;
    requires javafx.base;
    requires webfx.extras.type;
    requires webfx.framework.shared.orm.datasourcemodelservice;
    requires webfx.framework.shared.orm.domainmodel;
    requires webfx.framework.shared.orm.domainmodelservice;
    requires webfx.framework.shared.orm.dql;
    requires webfx.framework.shared.orm.entity;
    requires webfx.framework.shared.orm.expression;
    requires webfx.platform.shared.async;
    requires webfx.platform.shared.json;
    requires webfx.platform.shared.query;
    requires webfx.platform.shared.resource;
    requires webfx.platform.shared.serial;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.base.shared.domainmodel.formatters;
    exports mongoose.base.shared.domainmodel.functions;
    exports mongoose.base.shared.services.datasourcemodel;
    exports mongoose.base.shared.services.domainmodel;

    // Resources packages
    opens mongoose.base.shared.domainmodel;

    // Provided services
    provides dev.webfx.framework.shared.services.datasourcemodel.spi.DataSourceModelProvider with mongoose.base.shared.services.datasourcemodel.MongooseDataSourceModelProvider;
    provides dev.webfx.framework.shared.services.domainmodel.spi.DomainModelProvider with mongoose.base.shared.services.domainmodel.MongooseDomainModelProvider;

}