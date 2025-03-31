package locators;

public class FlixBusLocators {
    private static final String FLIXBUS_URL = "https://www.flixbus.ca/";
    private static final String FLIXBUS_CLOSE_BUTTON = "//*[@id=\"uc-center-container\"]/div[2]/div/div/div/div/button[2]";
    private static final String FLIXBUS_ONEWAY_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[1]/fieldset/div[1]/div/label";
    private static final String FLIXBUS_ROUNDTRIP_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[1]/fieldset/div[2]/div/label";
    private static final String FLIXBUS_FROM_INPUT = "//*[@id=\"searchInput-from\"]";
    private static final String FLIXBUS_TO_INPUT = "//*[@id=\"searchInput-to\"]";
    private static final String FLIXBUS_TRAVELERS_DROP = "//*[@id=\"productSummary\"]";
    private static final String FLIXBUS_ADULTS = "//*[@id=\"search.form.label.adult\"]";
    private static final String FLIXBUS_CHILDREN = "//*[@id=\"passenger.children\"]";
    private static final String FLIXBUS_BIKES = "//*[@id=\"search.form.label.bike_slot\"]";
    private static final String FLIXBUS_WHEELCHAIR = "//*[@id=\"search.form.label.wheelchair\"]";
    private static final String FLIXBUS_SEARCH_BUTTON = "//*[@id=\"search-mask-component\"]/div/div/div/div[5]/div/button";
    private static final String FLIXBUS_DATE_BUTTON = "//*[@id=\"dateInput-from\"]";
    private static final String FLIXBUS_RETDATE_BUTTON = "//*[@id=\"dateInput-to\"]";
    private static final String FLIXBUS_MONTH_YEAR = "//*[@id=\"calendar-grid\"]/caption";
    private static final String FLIXBUS_NEXT_MONTH = "//*[@id=\"dialog-date-from\"]/div/div/button[2]";
    private static final String FLIXBUS_DAY = "//*/tbody/tr[row]/td[col]/button";
    public String getURL() {
        return FLIXBUS_URL;
    }
    public String getOneWayButton() {
        return FLIXBUS_ONEWAY_BUTTON;
    }
    public String getRoundTripButton() {
        return FLIXBUS_ROUNDTRIP_BUTTON;
    }
    public String getReturnDateButton() { return FLIXBUS_RETDATE_BUTTON; }
    public String getNextMonth() { return FLIXBUS_NEXT_MONTH; }
    public String getFromInput() {
        return FLIXBUS_FROM_INPUT;
    }
    public String getToInput() {
        return FLIXBUS_TO_INPUT;
    }
    public String getTravelersDrop() {
        return FLIXBUS_TRAVELERS_DROP;
    }
    public String getAdults() { return FLIXBUS_ADULTS; }
    public String getChildren() { return FLIXBUS_CHILDREN; }
    public String getBikes() { return FLIXBUS_BIKES; }
    public String getWheelchair() { return FLIXBUS_WHEELCHAIR; }
    public String getSearchButton() {
        return FLIXBUS_SEARCH_BUTTON;
    }
    public String getDateButton() {
        return FLIXBUS_DATE_BUTTON;
    }
    public String getMonthYear() {
        return FLIXBUS_MONTH_YEAR;
    }
    public String getDay() {
        return FLIXBUS_DAY;
    }
    public String getCloseButton() { return FLIXBUS_CLOSE_BUTTON; }
}
