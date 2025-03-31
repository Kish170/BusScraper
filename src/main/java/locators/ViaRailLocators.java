package locators;

public class ViaRailLocators {
    private static final String VIARAIL_URL = "https://www.viarail.ca/en/plan/book-travel";
//    private static final String VIARAIL_CLOSE_BUTTON = "//*[@id=\"bx-close-inside-2488666\"]";
    private static final String VIARAIL_ONEWAY_BUTTON = "//*[@id=\"book-a-ticket\"]/div[3]/form/label[2]";
    private static final String VIARAIL_ROUNDTRIP_BUTTON = "//*[@id=\"book-a-ticket\"]/div[3]/form/label[1]";
    private static final String VIARAIL_FROM_INPUT = "//*[@id=\"stationFrom-38\"]";
    private static final String VIARAIL_TO_INPUT = "//*[@id=\"stationTo-39\"]";
    private static final String VIARAIL_TRAVELERS_DROP = "//*[@id=\"allPassengers-31\"]";
    private static final String VIARAIL_ADULTS = "//*[@id=\"passenger_selection-44\"]/ul/li[1]/div[2]/button[2]";
    private static final String VIARAIL_CHILDREN = "//*[@id=\"passenger_selection-44\"]/ul/li[4]/div[2]/button[2]";
    private static final String VIARAIL_SENIOR = "//*[@id=\"passenger_selection-44\"]/ul/li[2]/div[2]/button[2]";
    private static final String VIARAIL_YOUTH = "//*[@id=\"passenger_selection-44\"]/ul/li[3]/div[2]/button[2]";
    private static final String VIARAIL_INFANT = "//*[@id=\"passenger_selection-44\"]/ul/li[5]/div[2]/button[2]";
    private static final String VIARAIL_TRAVELERS_CLOSE = "//*[@id=\"passenger_selection-44\"]/div[2]/button[2]";
    private static final String VIARAIL_SEARCH_BUTTON = "//*[@id=\"book-a-ticket\"]/form/div[2]/div/div[2]/div[2]/div/button";
    private static final String VIARAIL_DATE_BUTTON = "//*[@id=\"datepickerTo-37\"]";
    private static final String VIARAIL_RETDATE_BUTTON = "//*[@id=\"datepickerTo-36\"]";
    private static final String VIARAIL_MONTH_YEAR = "//*/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[month]/div";//*[@id="vuejsApp-booking"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div
    //alternates between two(1,2) divs as it shows two months need to figure how to deal with that
    private static final String VIARAIL_DAY = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[day]";
    //first block of calendar is div[8] and increments
    private static final String VIARAIL_NEXTMONTH = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]";
    private static final String VIARAIL_SELECT_BUTTON = "//*[@id=\"vuejsApp-booking\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[6]/button";
    public String getURL() { return VIARAIL_URL; }

}
