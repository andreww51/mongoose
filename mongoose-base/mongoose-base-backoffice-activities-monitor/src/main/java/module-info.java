// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.base.backoffice.activities.monitor {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires mongoose.base.client.activity;
    requires webfx.extras.visual.base;
    requires webfx.extras.visual.controls.charts;
    requires webfx.framework.client.activity;
    requires webfx.framework.client.orm.domainmodel.activity;
    requires webfx.framework.client.orm.reactive.entities;
    requires webfx.framework.client.orm.reactive.visual;
    requires webfx.framework.client.uirouter;
    requires webfx.framework.client.util;
    requires webfx.framework.shared.operation;
    requires webfx.framework.shared.orm.entity;
    requires webfx.framework.shared.router;
    requires webfx.platform.client.windowhistory;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.base.backoffice.activities.monitor;
    exports mongoose.base.backoffice.activities.monitor.routing;
    exports mongoose.base.backoffice.operations.routes.monitor;

    // Provided services
    provides dev.webfx.framework.client.operations.route.RouteRequestEmitter with mongoose.base.backoffice.activities.monitor.RouteToMonitorRequestEmitter;
    provides dev.webfx.framework.client.ui.uirouter.UiRoute with mongoose.base.backoffice.activities.monitor.MonitorUiRoute;

}