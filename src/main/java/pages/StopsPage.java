package pages;

import locators.LocatorsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StopsPage extends BasePage {
    public StopsPage(WebDriver driver, LocatorsBase locator) {
        super(driver, locator);
    }

    @Override
    public void openPage() {
        navigateTo(locator.getStopsURL());
    }

    @Override
    public WebElement checkElement(String xpath) {
        return null;
    }
}
