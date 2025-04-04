package locators;

public class MegabusLocators {
    private static final String MEGABUS_URL = "https://ca.megabus.com/";
    private static final String MEGABUS_CLOSE_BUTTON = "//*[@id=\"bx-close-inside-2488666\"]";
    private static final String MEGABUS_ONEWAY_BUTTON = "//*[@id=\"homepageContentArea\"]/div[1]/mb-user-home/div/div/div/div/div/mb-journey-planner-lite/div/div/mb-journey-search/div/div/div/div/form/div[1]/div/fieldset/mb-radio-group/div[1]/label";
    private static final String MEGABUS_ROUNDTRIP_BUTTON = "//*[@id=\"homepageContentArea\"]/div[1]/mb-user-home/div/div/div/div/div/mb-journey-planner-lite/div/div/mb-journey-search/div/div/div/div/form/div[1]/div/fieldset/mb-radio-group/div[2]/label";
    private static final String MEGABUS_FROM_INPUT = "//*[@id=\"startingAt\"]";
    private static final String MEGABUS_TO_INPUT = "//*[@id=\"goingTo\"]";
    private static final String MEGABUS_TRAVELERS_INPUT = "//*[@id=\"totalPassengers\"]";
    private static final String MEGABUS_SEARCH_BUTTON = "//*[@id=\"findTickets\"]";
    private static final String MEGABUS_DATE_BUTTON = "//*[@id=\"mat-input-0\"]";
    private static final String MEGABUS_RETDATE_BUTTON = "//*[@id=\"mat-input-1\"]";
    private static final String MEGABUS_MONTH_YEAR = "//*/mat-calendar-header/div/div/button[1]/span[2]/span";
    private static final String MEGABUS_DAY = "//*/div/mat-month-view/table/tbody/tr[row]/td[col]/button";
    private static final String MEGABUS_NEXTMONTH = "//*/mat-calendar-header/div/div/button[3]";

    public String getURL() { return MEGABUS_URL; }

    public String getCloseButton() {
        return MEGABUS_CLOSE_BUTTON;
    }

    public String getOneWayButton() {
        return MEGABUS_ONEWAY_BUTTON;
    }

    public String getRoundTripButton() {
        return MEGABUS_ROUNDTRIP_BUTTON;
    }

    public String getReturnDateButton() { return MEGABUS_RETDATE_BUTTON; }

    public String getFromInput() {
        return MEGABUS_FROM_INPUT;
    }

    public String getToInput() {
        return MEGABUS_TO_INPUT;
    }

    public String getTravelersInput() {
        return MEGABUS_TRAVELERS_INPUT;
    }

    public String getSearchButton() {
        return MEGABUS_SEARCH_BUTTON;
    }

    public String getDateButton() {
        return MEGABUS_DATE_BUTTON;
    }

    public String getMonthYear() {
        return MEGABUS_MONTH_YEAR;
    }

    public String getDay() {
        return MEGABUS_DAY;
    }

    public String getNextMonth() {
        return MEGABUS_NEXTMONTH;
    }
}
