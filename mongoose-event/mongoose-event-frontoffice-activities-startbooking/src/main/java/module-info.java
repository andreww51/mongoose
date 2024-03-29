// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.event.frontoffice.activities.startbooking {

    // Direct dependencies modules
    requires javafx.controls;
    requires javafx.graphics;
    requires mongoose.base.client.entities;
    requires mongoose.base.client.icons;
    requires mongoose.base.client.util;
    requires mongoose.base.shared.entities;
    requires mongoose.ecommerce.client.bookingprocess;
    requires mongoose.event.frontoffice.activities.fees;
    requires mongoose.event.frontoffice.activities.options;
    requires mongoose.event.frontoffice.activities.program;
    requires mongoose.event.frontoffice.activities.terms;
    requires webfx.extras.imagestore;
    requires webfx.framework.client.action;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.orm.domainmodel.activity;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.client.util;
    requires webfx.kit.util;
    requires webfx.platform.client.uischeduler;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.shared.async;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.event.frontoffice.activities.startbooking;
    exports mongoose.event.frontoffice.activities.startbooking.routing;
    exports mongoose.event.frontoffice.operations.startbooking;

    // Provided services
    provides dev.webfx.framework.client.ui.uirouter.UiRoute with mongoose.event.frontoffice.activities.startbooking.StartBookingUiRoute;

}