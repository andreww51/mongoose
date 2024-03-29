package mongoose.ecommerce.client.businessdata.preselection;

import mongoose.base.client.aggregates.event.EventAggregate;
import mongoose.ecommerce.client.businessdata.workingdocument.WorkingDocument;
import mongoose.ecommerce.client.businessdata.workingdocument.WorkingDocumentLine;
import mongoose.hotel.shared.businessdata.time.DateTimeRange;
import mongoose.base.shared.entities.Label;
import mongoose.base.shared.entities.Option;
import mongoose.base.shared.entities.formatters.EventPriceFormatter;
import mongoose.base.client.entities.util.Labels;
import dev.webfx.framework.shared.orm.entity.Entities;
import dev.webfx.platform.shared.services.query.QueryResult;
import dev.webfx.platform.shared.util.Booleans;
import dev.webfx.platform.shared.util.collection.Collections;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class OptionsPreselection {

    private final EventAggregate eventAggregate;
    private final Label label;
    private final String i18nKey; // alternative i18n key if label is null
    private final List<OptionPreselection> optionPreselections;

    public OptionsPreselection(EventAggregate eventAggregate, Label label, String i18nKey, List<OptionPreselection> optionPreselections) {
        this.eventAggregate = eventAggregate;
        this.label = label;
        this.i18nKey = i18nKey;
        this.optionPreselections = optionPreselections;
    }

    public Label getLabel() {
        return label;
    }

    public List<OptionPreselection> getOptionPreselections() {
        return optionPreselections;
    }

    private WorkingDocument workingDocument;
    public WorkingDocument initializeNewWorkingDocument() {
        if (workingDocument == null)
            workingDocument = createNewWorkingDocument(null);
        else
            workingDocument.syncPersonDetails(eventAggregate.getPersonAggregate().getPreselectionProfilePerson());
        return workingDocument;
    }

    public WorkingDocument getWorkingDocument() {
        if (workingDocument == null)
            initializeNewWorkingDocument();
        return workingDocument;
    }

    public WorkingDocument createNewWorkingDocument(DateTimeRange workingDocumentDateTimeRange) {
        return new WorkingDocument(eventAggregate, Collections.map(optionPreselections, optionPreselection -> new WorkingDocumentLine(optionPreselection, workingDocumentDateTimeRange)));
    }

    public WorkingDocumentLine getAccommodationLine() {
        return getWorkingDocument().getAccommodationLine();
    }

    public boolean hasAccommodation() {
        return getAccommodationLine() != null;
    }

    public boolean hasAccommodationExcludingSharing() {
        WorkingDocumentLine accommodationLine = getAccommodationLine();
        return accommodationLine != null && Booleans.isFalse(accommodationLine.getItem().isShare_mate());
    }

    public Option getAccommodationOption() {
        WorkingDocumentLine accommodationLine = getAccommodationLine();
        return accommodationLine == null ? null : accommodationLine.getOption();
    }

    public boolean isForceSoldout() {
        Option accommodationOption = getAccommodationOption();
        return accommodationOption != null && Booleans.isTrue(accommodationOption.isForceSoldout());
    }

    public int computePrice() {
        return initializeNewWorkingDocument().applyBusinessRules().computePrice();
    }

    public String getDisplayName() {
        return Labels.instantTranslateLabel(label, i18nKey);
    }

    public String getDisplayName(Object language) {
        return Labels.instantTranslateLabel(label, language, i18nKey);
    }

    public Object getDisplayPrice() {
        return EventPriceFormatter.formatWithCurrency(computePrice(), eventAggregate.getEvent());
    }

    public Object getDisplayAvailability(EventAggregate eventAggregate) {
        QueryResult rs = eventAggregate.getEventAvailabilities();
        if (rs != null) {
            WorkingDocumentLine accommodationLine = getWorkingDocument().getAccommodationLine();
            if (accommodationLine != null) {
                Object sitePk = Entities.getPrimaryKey(accommodationLine.getSite());
                Object itemPk = Entities.getPrimaryKey(accommodationLine.getItem());
                for (int rowIndex = 0; rowIndex < rs.getRowCount(); rowIndex++) {
                    if (rs.getValue(rowIndex, 1).equals(sitePk) && rs.getValue(rowIndex, 2).equals(itemPk))
                        return rs.getValue(rowIndex, 4);
                }
            }
        }
        return null;
    }

    public void setEventActive() {
        ActiveOptionsPreselectionsByEventStore.setActiveOptionsPreselection(this, eventAggregate);
    }

    @Override
    public String toString() {
        return getDisplayName("en");
    }
}
