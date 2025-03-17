package locators;

public class MegabusLocators implements LocatorsBase {
    private static final String MEGABUS_URL = "https://ca.megabus.com/";
    private static final String MEGABUS_STOPS_URL = "https://ca.megabus.com/stops";
    private static final String MEGABUS_CLOSE_BUTTON = "//*[@id=\"bx-close-inside-2488666\"]";
    private static final String MEGABUS_TRIP_BUTTON = "//*[@id=\"homepageContentArea\"]/div[1]/mb-user-home/div/div/div/div/div/mb-journey-planner-lite/div/div/mb-journey-search/div/div/div/div/form/div[1]/div/fieldset/mb-radio-group/div[1]/label";
    private static final String MEGABUS_CITY_ELEMENTS = "//h4/a";
    private static final String MEGABUS_FROM_INPUT = "//*[@id=\"startingAt\"]";
    private static final String MEGABUS_TO_INPUT = "//*[@id=\"goingTo\"]";
    private static final String MEGABUS_TRAVELERS_INPUT = "//*[@id=\"totalPassengers_plus\"]";
    private static final String MEGABUS_SEARCH_BUTTON = "//*[@id=\"findTickets\"]";
    private static final String MEGABUS_DATE_BUTTON = "//*[@id=\"mat-input-0\"]";
    private static final String MEGABUS_MONTH_YEAR = "//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]/span[2]/span";
    private static final String MEGABUS_DAY = "//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[3]/td[7]/button/span[1]";
    private static final String MEGABUS_POPUP = "//*[@id=\"bx-close-inside-1317905\"]/svg";

    @Override
    public String getURL() {
        return MEGABUS_URL;
    }

    @Override
    public String getStopsURL() {
        return MEGABUS_STOPS_URL;
    }

    @Override
    public String getCloseButton() {
        return MEGABUS_CLOSE_BUTTON;
    }

    @Override
    public String getTripButton() {
        return MEGABUS_TRIP_BUTTON;
    }

    @Override
    public String getCityElements() {
        return MEGABUS_CITY_ELEMENTS;
    }

    @Override
    public String getFromInput() {
        return MEGABUS_FROM_INPUT;
    }

    @Override
    public String getToInput() {
        return MEGABUS_TO_INPUT;
    }

    @Override
    public String getTravelersInput() {
        return MEGABUS_TRAVELERS_INPUT;
    }

    @Override
    public String getSearchButton() {
        return MEGABUS_SEARCH_BUTTON;
    }

    @Override
    public String getDateButton() {
        return MEGABUS_DATE_BUTTON;
    }

    @Override
    public String getMonthYear() {
        return MEGABUS_MONTH_YEAR;
    }

    @Override
    public String getDay() {
        return MEGABUS_DAY;
    }
}
