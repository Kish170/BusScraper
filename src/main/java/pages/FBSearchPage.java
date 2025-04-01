package pages;

import locators.FlixBusLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

public class FBSearchPage extends BasePage{
    FlixBusLocators locator;
    public FBSearchPage(WebDriver driver) {
        super(driver);
        this.locator = new FlixBusLocators();
    }
    private void searchTrip(String from, String to, int adults, int children, int bikes, int wheelchair, LocalDate date, LocalDate returnDate, boolean isRoundTrip) {
        openPage();
        sleep(3);
        WebElement shadowParent = driver.findElement(By.ByCssSelector.cssSelector("#usercentrics-root"));
        SearchContext shadowRoot = shadowParent.getShadowRoot();
        WebElement acceptButton = shadowRoot.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        acceptButton.click();
        WebElement tripButton = isRoundTrip ? checkElement(locator.getRoundTripButton()) : checkElement(locator.getOneWayButton());
        WebElement fromCity = checkElement(locator.getFromInput());
        WebElement toCity = checkElement(locator.getToInput());
        WebElement dateButton = checkElement(locator.getDateButton());
        WebElement travelersInput = checkElement(locator.getTravelersDrop());
        WebElement searchButton = checkElement(locator.getSearchButton());

        tripButton.click();
        fromCity.clear();
        fromCity.sendKeys(from);
        this.sleep(2);
        actions.moveToElement(fromCity).sendKeys(Keys.ENTER).perform();

        toCity.clear();
        toCity.sendKeys(to);
        this.sleep(2);
        actions.moveToElement(toCity).sendKeys(Keys.ENTER).perform();
        dateButton.click();
        setDate(date, true);

        if (isRoundTrip && returnDate != null) {
            setDate(returnDate, false);
        }

        travelersInput.click();
        WebElement adultsInput = checkElement(locator.getAdults());
        WebElement childrenInput = checkElement(locator.getChildren());
        WebElement bikesInput = checkElement(locator.getBikes());
        WebElement wheelchairInput = checkElement(locator.getWheelchair());
        adultsInput.clear();
        adultsInput.sendKeys(String.valueOf(adults));
        childrenInput.clear();
        childrenInput.sendKeys(String.valueOf(children));
        bikesInput.clear();
        bikesInput.sendKeys(String.valueOf(bikes));
        wheelchairInput.clear();
        wheelchairInput.sendKeys(String.valueOf(wheelchair));
        sleep(5);
        searchButton.click();
    }

    public void searchTrip(String from, String to, int adults, int children, int bikes, int wheelchair, LocalDate date) {
        searchTrip(from, to, adults, children, bikes, wheelchair, date, null, false);
    }
    public void searchTrip(String from, String to, int adults, int children, int bikes, int wheelchair, LocalDate date, LocalDate returnDate) {
        searchTrip(from, to, adults, children, bikes, wheelchair, date, returnDate, true);
    }

    public void setDate (LocalDate date, boolean isDeparture) {
        String monthStr = date.getMonth().name().substring(0, 3).toUpperCase();

        WebElement month = checkElement(locator.getMonthYear());

        LocalDate firstDate = LocalDate.of(date.getYear(), date.getMonth(), 1);
        int dayOfWeek = firstDate.getDayOfWeek().getValue();

        //find how many rows in calendar
        int td, tr;
        if (dayOfWeek > 4) {
            td = 6;
        } else {
            td = 5;
        }

        //find how many days are in the first row
        int firstRowDays = 8 - dayOfWeek;
        if (date.getDayOfMonth() <= firstRowDays) { //if today is in the first row
            td = 1;
            tr = date.getDayOfWeek().getValue();
        } else { //if today is in any other row
            // Remaining days after the first row
            int remainingDays = date.getDayOfMonth() - firstRowDays;
            // Each full row contains 7 days
            td = (int) Math.ceil(remainingDays / 7.0) + 1;
            tr = date.getDayOfWeek().getValue();
        }

        String dayLocator = locator.getDay().replace("row", String.valueOf(td)).replace("col", String.valueOf(tr));
        String nextMonth = isDeparture ? locator.getNextMonth() : locator.getNextMonth().replace("from", "to");
        WebElement nextMonthButton = checkElement(nextMonth);
        int maxClicks = 24;
        int attempts = 0;
        while (!month.getText().toUpperCase().startsWith(monthStr) && attempts < maxClicks) {
            System.out.println(month.getText().toLowerCase() + " " + monthStr + " " + attempts);
            if(attempts % 2 == 0) {
                attempts++;
                continue;
            }
            attempts++;
            nextMonthButton.click();
            month = checkElement(locator.getMonthYear());
        }
        WebElement day = checkElement(dayLocator);
        day.click();
    }
    @Override
    public void openPage() {
        navigateTo(locator.getURL());
    }
}
