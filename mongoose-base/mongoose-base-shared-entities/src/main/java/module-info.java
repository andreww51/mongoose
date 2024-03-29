// File managed by WebFX (DO NOT EDIT MANUALLY)

module mongoose.base.shared.entities {

    // Direct dependencies modules
    requires java.base;
    requires mongoose.base.shared.domainmodel;
    requires mongoose.hotel.shared.time;
    requires webfx.framework.shared.orm.entity;
    requires webfx.platform.shared.util;

    // Exported packages
    exports mongoose.base.shared.entities;
    exports mongoose.base.shared.entities.formatters;
    exports mongoose.base.shared.entities.impl;
    exports mongoose.base.shared.entities.markers;
    exports mongoose.base.shared.services.systemmetrics;

    // Provided services
    provides dev.webfx.framework.shared.orm.entity.EntityFactoryProvider with mongoose.base.shared.entities.impl.AttendanceImpl.ProvidedFactory, mongoose.base.shared.entities.impl.CartImpl.ProvidedFactory, mongoose.base.shared.entities.impl.CountryImpl.ProvidedFactory, mongoose.base.shared.entities.impl.CurrencyImpl.ProvidedFactory, mongoose.base.shared.entities.impl.DateInfoImpl.ProvidedFactory, mongoose.base.shared.entities.impl.DocumentImpl.ProvidedFactory, mongoose.base.shared.entities.impl.DocumentLineImpl.ProvidedFactory, mongoose.base.shared.entities.impl.EventImpl.ProvidedFactory, mongoose.base.shared.entities.impl.FilterImpl.ProvidedFactory, mongoose.base.shared.entities.impl.GatewayParameterImpl.ProvidedFactory, mongoose.base.shared.entities.impl.HistoryImpl.ProvidedFactory, mongoose.base.shared.entities.impl.ImageImpl.ProvidedFactory, mongoose.base.shared.entities.impl.ItemFamilyImpl.ProvidedFactory, mongoose.base.shared.entities.impl.ItemImpl.ProvidedFactory, mongoose.base.shared.entities.impl.LabelImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MailImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MethodImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MoneyTransferImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MoneyAccountImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MoneyAccountTypeImpl.ProvidedFactory, mongoose.base.shared.entities.impl.MoneyFlowImpl.ProvidedFactory, mongoose.base.shared.entities.impl.OptionImpl.ProvidedFactory, mongoose.base.shared.entities.impl.OrganizationImpl.ProvidedFactory, mongoose.base.shared.entities.impl.OrganizationTypeImpl.ProvidedFactory, mongoose.base.shared.entities.impl.PersonImpl.ProvidedFactory, mongoose.base.shared.entities.impl.RateImpl.ProvidedFactory, mongoose.base.shared.entities.impl.SiteImpl.ProvidedFactory, mongoose.base.shared.entities.impl.SystemMetricsEntityImpl.ProvidedFactory, mongoose.base.shared.entities.impl.TeacherImpl.ProvidedFactory;

}