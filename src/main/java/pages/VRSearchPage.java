package pages;

import locators.ViaRailLocators;
import org.openqa.selenium.*;
import java.time.LocalDate;

public class VRSearchPage extends BasePage {
    ViaRailLocators locator;

    public VRSearchPage(WebDriver driver) {
        super(driver);
        this.locator = new ViaRailLocators();
    }

    @Override
    public void openPage() {
        navigateTo(locator.getURL());
    }

    private void searchTrip(String from, String to, int adults, int children, int youth, int senior, int infant, LocalDate date, LocalDate returnDate, boolean isRoundTrip) {
        openPage();
        WebElement closeButton = checkElement(locator.getCloseButton());
        if (closeButton != null) {
            closeButton.click();
        }
        WebElement tripButton = isRoundTrip ? checkElement(locator.getRoundTripButton()) : checkElement(locator.getOneWayButton());
        WebElement fromCity = checkElement(locator.getFromInput());
        WebElement toCity = checkElement(locator.getToInput());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", tripButton);
        fromCity.clear();
        fromCity.sendKeys(from);
        this.sleep(2);
        actions.moveToElement(fromCity).sendKeys(Keys.ENTER).perform();

        toCity.clear();
        toCity.sendKeys(to);
        this.sleep(2);
        actions.moveToElement(toCity).sendKeys(Keys.ENTER).perform();

        WebElement dateButton = checkElement(locator.getDateButton());
        WebElement travelersInput = checkElement(locator.getTravelersDrop());
        WebElement searchButton = checkElement(locator.getSearchButton());

        dateButton.click();
        setDate(date, true);

        if (isRoundTrip && returnDate != null) {
            setDate(returnDate, false);
        }

        WebElement select = checkElement(locator.getSelectButton());
        select.click();

        travelersInput.click();
        WebElement adultsInput = checkElement(locator.getAdults());
        WebElement childrenInput = checkElement(locator.getChildren());
        WebElement youthInput = checkElement(locator.getYouth());
        WebElement seniorInput = checkElement(locator.getSenior());
        WebElement infantInput = checkElement(locator.getSenior());
        WebElement travelerClose = checkElement(locator.getTravelersClose());
        incrementTraveler(adultsInput, adults);
        incrementTraveler(childrenInput, children);
        incrementTraveler(youthInput, youth);
        incrementTraveler(seniorInput, senior);
        incrementTraveler(infantInput, infant);
        travelerClose.click();
        sleep(5);
        searchButton.click();
    }

    private void incrementTraveler(WebElement input, int count) {
        if(count >= 0) {
            for (int i = 0; i < count; i++) {
                input.click();
            }
        }
    }

    public void searchTrip(String from, String to, int adults, int children, int youth, int senior, int infant, LocalDate date) {
        searchTrip(from, to, adults, children, youth, senior, infant, date, null, false);
    }
    public void searchTrip(String from, String to, int adults, int children, int youth, int senior, int infant, LocalDate date, LocalDate returnDate) {
        searchTrip(from, to, adults, children, youth, senior, infant, date, returnDate, true);
    }

    public void setDate (LocalDate date, boolean isDeparture) {
        String monthStr = date.getMonth().name().substring(0, 3).toUpperCase();

        LocalDate firstDate = LocalDate.of(date.getYear(), date.getMonth(), 1);
        int dayOfWeek = firstDate.getDayOfWeek().getValue();

        //find how many rows in calendar
        int tr;
        tr = 8 + dayOfWeek - 1 + date.getDayOfMonth();
        System.out.println("tr: " + tr);

        String dayLocator = locator.getDay().replace("day", String.valueOf(tr));
        String nextMonth = isDeparture ? locator.getNextMonth() : locator.getNextMonth().replace("from", "to");
        WebElement nextMonthButton = checkElement(nextMonth);
        int maxClicks = 24;
        int attempts = 0;
        String month = locator.getMonthYear().replace("month", "1");
        WebElement monthElement = checkElement(month);
        while (!monthElement.getText().toUpperCase().startsWith(monthStr) && attempts < maxClicks) {
            System.out.println(monthElement.getText().toLowerCase() + " " + monthStr + " " + attempts);

            if (attempts % 2 == 0) {
                month = locator.getMonthYear().replace("month", "2");
            } else {
                month = locator.getMonthYear().replace("month", "1");
                nextMonthButton.click();
                sleep(1);
            }

            monthElement = checkElement(month);
            attempts++;
        }
        WebElement day = checkElement(dayLocator);
        day.click();
    }


}
