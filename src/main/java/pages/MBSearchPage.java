package pages;

import locators.MegabusLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;

public class MBSearchPage extends BasePage {
    MegabusLocators locator;
    public MBSearchPage(WebDriver driver) {
        super(driver);
        this.locator = new MegabusLocators();
    }
    @Override
    public void openPage() {
        navigateTo(locator.getURL());
    }

    private void searchTrip(String from, String to, int travelers, LocalDate date, LocalDate returnDate, boolean isRoundTrip) {
        openPage();
        WebElement closeButton = checkElement(locator.getCloseButton());//un
        if (closeButton != null) {
            closeButton.click();
        }

        WebElement tripButton = isRoundTrip ? checkElement(locator.getRoundTripButton()) : checkElement(locator.getOneWayButton());
        WebElement fromCity = checkElement(locator.getFromInput());
        WebElement toCity = checkElement(locator.getToInput());
        WebElement dateButton = checkElement(locator.getDateButton());
        WebElement incrementTravelers = checkElement(locator.getTravelersInput());
        WebElement searchButton = checkElement(locator.getSearchButton());

        tripButton.click();
        fromCity.sendKeys(from);
        this.sleep(2);
        actions.moveToElement(fromCity).sendKeys(Keys.ENTER).perform();

        toCity.sendKeys(to);
        this.sleep(2);
        actions.moveToElement(toCity).sendKeys(Keys.ENTER).perform();
        dateButton.click();
        setDate(date);

        if (isRoundTrip && returnDate != null) {
            WebElement retDateButton = checkElement(locator.getReturnDateButton());
            retDateButton.click();
            setDate(returnDate);
        }

        for (int i = 1; i < travelers; i++) {
            incrementTravelers.click();
        }
        searchButton.click();
    }

    public void searchTrip(String from, String to, int travelers, LocalDate date) {
        searchTrip(from, to, travelers, date, null, false);
    }
    public void searchTrip(String from, String to, int travelers, LocalDate date, LocalDate returnDate) {
        searchTrip(from, to, travelers, date, returnDate, true);
    }

    public void setDate (LocalDate date) {
        String monthStr = date.getMonth().name().substring(0, 3).toUpperCase();
        String dayStr = String.valueOf(date.getDayOfMonth());

        WebElement month = checkElement(locator.getMonthYear());

        LocalDate firstDate = LocalDate.of(date.getYear(), date.getMonth(), 1);
        int dayOfWeek = firstDate.getDayOfWeek().getValue();

        //find how many rows in calendar
        int td, tr;
        if (dayOfWeek > 3) {
            td = 6;
        } else {
            td = 5;
        }

        //find how many days are in the first row
        int firstRowDays = 8 - dayOfWeek;
        if (date.getDayOfMonth() <= firstRowDays) { //if today is in the first row
            td = dayOfWeek <= 3 ? 2 : 1;// annoying edge case because of the table set up used by megabus
            tr = dayOfWeek == 7 ? date.getDayOfWeek().getValue() + 1 : date.getDayOfMonth() + 1;
        } else { //if today is in any other row
            // Remaining days after the first row
            int remainingDays = date.getDayOfMonth() - firstRowDays;
            // Each full row contains 7 days
            td = (dayOfWeek <= 3 ? 2 : 1) + (int) Math.ceil(remainingDays / 7.0);
            tr = date.getDayOfWeek().getValue() + 1;
        }
        String dayText = locator.getDay();

        String dayLocator = locator.getDay().replace("row", String.valueOf(td)).replace("col", String.valueOf(tr));
        WebElement nextMonthButton = checkElement(locator.getNextMonth());
        int maxClicks = 12;
        int attempts = 0;
        while (!month.getText().startsWith(monthStr) && attempts < maxClicks) {
            nextMonthButton.click();
            attempts++;
        }
        WebElement day = checkElement(dayLocator);
        day.click();
    }
}
