// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.ecommerce.frontoffice.activities.payment {

    // Direct dependencies modules
    requires java.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires mongoose.base.client.aggregates;
    requires mongoose.base.client.entities;
    requires mongoose.base.client.util;
    requires mongoose.base.shared.domainmodel;
    requires mongoose.base.shared.entities;
    requires mongoose.ecommerce.frontoffice.activities.cart.routing;
    requires mongoose.event.client.sectionpanel;
    requires webfx.extras.webtext.controls;
    requires webfx.framework.client.action;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.controls;
    requires webfx.framework.client.i18n;
    requires webfx.framework.client.orm.domainmodel.activity;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.client.util;
    requires webfx.framework.shared.orm.entity;
    requires webfx.platform.client.uischeduler;
    requires webfx.platform.client.websocketbus;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.client.windowlocation;
    requires webfx.platform.shared.async;
    requires webfx.platform.shared.bus;
    requires webfx.platform.shared.log;
    requires webfx.platform.shared.submit;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.ecommerce.frontoffice.activities.payment;
    exports mongoose.ecommerce.frontoffice.activities.payment.routing;
    exports mongoose.ecommerce.frontoffice.operations.payment;

    // Provided services
    provides dev.webfx.framework.client.ui.uirouter.UiRoute with mongoose.ecommerce.frontoffice.activities.payment.PaymentUiRoute;

}