package pages;

import locators.ViaRailLocators;
import org.openqa.selenium.WebDriver;

public class VRSearchPage extends BasePage {
    ViaRailLocators locator;

    public VRSearchPage(WebDriver driver) {
        super(driver);
        this.locator = new ViaRailLocators();
    }

    @Override
    public void openPage() {
    }
}
