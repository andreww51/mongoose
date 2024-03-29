// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.base.client.application {

    // Direct dependencies modules
    requires java.base;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires mongoose.base.client.activity;
    requires mongoose.base.client.icons;
    requires webfx.extras.imagestore;
    requires webfx.framework.client.action;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.i18n;
    requires webfx.framework.client.operationaction;
    requires webfx.framework.client.orm.domainmodel.activity;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.client.util;
    requires webfx.framework.shared.operation;
    requires webfx.framework.shared.orm.datasourcemodelservice;
    requires webfx.framework.shared.router;
    requires webfx.kit.launcher;
    requires webfx.kit.util;
    requires webfx.platform.client.uischeduler;
    requires webfx.platform.shared.buscall;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.base.client.application;

    // Resources packages
    opens images.buddhas;
    opens mongoose.base.client.images;

}