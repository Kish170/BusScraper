package locators;

public class FlixBusLocators implements LocatorsBase{
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
    @Override
    public String getURL() {
        return null;
    }

    @Override
    public String getStopsURL() {
        return null;
    }

    @Override
    public String getCloseButton() {
        return null;
    }

    public String getOneWayButton() {
        return FLIXBUS_ONEWAY_BUTTON;
    }

    @Override
    public String getCityElements() {
        return null;
    }

    @Override
    public String getRoundTripButton() {
        return FLIXBUS_ROUNDTRIP_BUTTON;
    }

    @Override
    public String getReturnDateButton() {
        return null;
    }

    @Override
    public String getFromInput() {
        return null;
    }

    @Override
    public String getToInput() {
        return null;
    }

    @Override
    public String getTravelersInput() {
        return null;
    }

    @Override
    public String getSearchButton() {
        return null;
    }

    @Override
    public String getDateButton() {
        return null;
    }

    @Override
    public String getMonthYear() {
        return null;
    }

    @Override
    public String getDay() {
        return null;
    }
}
