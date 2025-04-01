package locators;

public class ViaRailLocators {
    private static final String VIARAIL_URL = "https://www.viarail.ca/en/plan/book-travel";
    private static final String VIARAIL_CLOSE_BUTTON = "//*[@id=\"via-cookie-banner\"]/div/div/div[2]/button";
    private static final String VIARAIL_ONEWAY_BUTTON = "//*[@id=\"oneWayTabId-41\"]";
    private static final String VIARAIL_ROUNDTRIP_BUTTON = "//*[@id=\"roundTripTabId-40\"]";
    private static final String VIARAIL_FROM_INPUT = "//*[@id=\"stationFrom-38\"]";
    private static final String VIARAIL_TO_INPUT = "//*[@id=\"stationTo-39\"]";
    private static final String VIARAIL_TRAVELERS_DROP = "//*[@id=\"allPassengers-31\"]";
    private static final String VIARAIL_ADULTS = "//*[@id=\"passenger_selection-44\"]/ul/li[1]/div[2]/button[2]";
    private static final String VIARAIL_CHILDREN = "//*[@id=\"passenger_selection-44\"]/ul/li[4]/div[2]/button[2]";
    private static final String VIARAIL_SENIOR = "//*[@id=\"passenger_selection-44\"]/ul/li[2]/div[2]/button[2]";
    private static final String VIARAIL_YOUTH = "//*[@id=\"passenger_selection-44\"]/ul/li[3]/div[2]/button[2]";
    private static final String VIARAIL_INFANT = "//*[@id=\"passenger_selection-44\"]/ul/li[5]/div[2]/button[2]";
    private static final String VIARAIL_TRAVELERS_CLOSE = "//*[@id=\"passenger_selection-44\"]/div[2]/button[2]";
    private static final String VIARAIL_SEARCH_BUTTON = "/html/body/div[3]/div/div/div[3]/div[2]/div/div[4]/div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/form/div[2]/div/div[2]/div[2]/div/button";
    private static final String VIARAIL_DATE_BUTTON = "//*[@id=\"datepickerTo-37\"]";
    private static final String VIARAIL_RETDATE_BUTTON = "//*[@id=\"datepickerTo-36\"]";
    private static final String VIARAIL_MONTH_YEAR = "//*/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[month]/div[1]/div";//*[@id="vuejsApp-booking"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div
    //alternates between two(1,2) divs as it shows two months need to figure how to deal with that
    private static final String VIARAIL_DAY = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[day]";
    //first block of calendar is div[8] and increments
    private static final String VIARAIL_NEXTMONTH = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]";
    private static final String VIARAIL_SELECT_BUTTON = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[6]/button";
    public String getURL() { return VIARAIL_URL; }
    public String getCloseButton() { return VIARAIL_CLOSE_BUTTON; }
    public String getOneWayButton() { return VIARAIL_ONEWAY_BUTTON; }
    public String getRoundTripButton() { return VIARAIL_ROUNDTRIP_BUTTON; }
    public String getReturnDateButton() { return VIARAIL_RETDATE_BUTTON; }
    public String getFromInput() { return VIARAIL_FROM_INPUT; }
    public String getToInput() { return VIARAIL_TO_INPUT; }
    public String getTravelersDrop() { return VIARAIL_TRAVELERS_DROP; }
    public String getAdults() { return VIARAIL_ADULTS; }
    public String getChildren() { return VIARAIL_CHILDREN; }
    public String getSenior() { return VIARAIL_SENIOR; }
    public String getYouth() { return VIARAIL_YOUTH; }
    public String getInfant() { return VIARAIL_INFANT; }
    public String getTravelersClose() { return VIARAIL_TRAVELERS_CLOSE; }
    public String getSearchButton() { return VIARAIL_SEARCH_BUTTON; }
    public String getDateButton() { return VIARAIL_DATE_BUTTON; }
    public String getMonthYear() { return VIARAIL_MONTH_YEAR; }
    public String getDay() { return VIARAIL_DAY; }
    public String getNextMonth() { return VIARAIL_NEXTMONTH; }
    public String getSelectButton() { return VIARAIL_SELECT_BUTTON; }


}
