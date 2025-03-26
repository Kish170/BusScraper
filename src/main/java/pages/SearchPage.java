package pages;

import locators.LocatorsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage<CustomDate> extends BasePage {
    public SearchPage(WebDriver driver, LocatorsBase locator) {
        super(driver, locator);
    }
    @Override
    public void openPage() {
        navigateTo(locator.getURL());
    }

    public void searchTrip(String from, String to, int travelers, CustomDate date) {
        openPage();
        WebElement closeButton = checkElement(locator.getCloseButton());
        closeButton.click();

        WebElement tripButton = checkElement(locator.getTripButton());
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
        System.out.println(date.toString());
        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(date.toString());
        String monthStr = null;
        String dayStr = null;
        if (matcher.find()) {
            monthStr = matcher.group(1);
            monthStr = monthStr.substring(0, 3).toUpperCase();
        }
        pattern = Pattern.compile("([0-9]+)");
        matcher = pattern.matcher(date.toString());
        if (matcher.find()) {
            dayStr = matcher.group(1);
        }
        WebElement month = checkElement(locator.getMonthYear());
        WebElement day = checkElement(locator.getDay());
        while (!month.getText().startsWith(monthStr) && !day.getText().equals(dayStr)) {
            actions.moveToElement(dateButton).sendKeys(Keys.ARROW_RIGHT).perform();
            month = checkElement(locator.getMonthYear());
            day = checkElement(locator.getDay());
        }
        actions.moveToElement(dateButton).sendKeys(Keys.ENTER).perform();
        for (int i = 1; i < travelers; i++) {
            incrementTravelers.click();
        }
        searchButton.click();
        this.sleep(5);
    }
}
