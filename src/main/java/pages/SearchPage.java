package pages;

import locators.LocatorsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver, LocatorsBase locator) {
        super(driver, locator);
    }
    @Override
    public void openPage() {
        navigateTo(locator.getURL());
    }

    public void searchTrip(String from, String to, int travelers) {
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
        WebElement month = checkElement(locator.getMonthYear());
        WebElement day = checkElement(locator.getDay());
        while (!month.getText().equals("APR 2025") && !day.getText().equals("1")) {
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
