package locators;

public class FlixBusLocators {
    private static final String FLIXBUS_URL = "https://www.flixbus.ca/";
    private static final String FLIXBUS_CLOSE_BUTTON = "";
    private static final String FLIXBUS_ONEWAY_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[1]/fieldset/div[1]/div/label";
    private static final String FLIXBUS_ROUNDTRIP_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[1]/fieldset/div[2]/div/label";
    private static final String FLIXBUS_CITY_ELEMENTS = "//h4/a";
    private static final String FLIXBUS_FROM_INPUT = "//*[@id=\"searchInputMobile-from\"]";
    private static final String FLIXBUS_TO_INPUT = "//*[@id=\"searchInputMobile-to\"]";
    private static final String FLIXBUS_TRAVELERS_INPUT = "//*[@id=\"productSummary\"]";
    private static final String FLIXBUS_ADULTS = "//*[@id=\"search.form.label.adult\"]";
    private static final String FLIXBUS_CHILDREN = "//*[@id=\"passenger.children\"]";
    private static final String FLIXBUS_SEARCH_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[5]/div/button";
    private static final String FLIXBUS_DATE_BUTTON = "//*[@id=\"dateInput-from\"]";
    private static final String FLIXBUS_MONTH_YEAR = "//*[@id=\"calendar-grid\"]/caption";
    private static final String FLIXBUS_DAY = "//*/tbody/tr[2]/td[*]/button";
    public String getURL() {
        return null;
    }

    public String getStopsURL() {
        return null;
    }

    public String getCloseButton() {
        return null;
    }

    public String getOneWayButton() {
        return FLIXBUS_ONEWAY_BUTTON;
    }

    public String getCityElements() {
        return null;
    }

    public String getRoundTripButton() {
        return FLIXBUS_ROUNDTRIP_BUTTON;
    }

    public String getReturnDateButton() {
        return null;
    }

    public String getNextMonth() {
        return null;
    }

    public String getFromInput() {
        return null;
    }

    public String getToInput() {
        return null;
    }

    public String getTravelersInput() {
        return null;
    }

    public String getSearchButton() {
        return null;
    }

    public String getDateButton() {
        return null;
    }

    public String getMonthYear() {
        return null;
    }

    public String getDay() {
        return null;
    }
}
