package pages;

import locators.LocatorsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected LocatorsBase locator;

    public BasePage(WebDriver driver, LocatorsBase locator){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.locator = locator;
    }
    public void sleep(int seconds){
        System.out.println("Waiting for "+ seconds+" seconds...");
        try{
            Thread.sleep(seconds* 1000L);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finished waiting");
    }
    public void scrollOnPage(WebDriver driver, int howMany, int scrollVolume){
        JavascriptExecutor jsEXE = (JavascriptExecutor) driver;
        for(int i = 0; i<= howMany; i++){
            jsEXE.executeScript(String.format("window.scrollBy(0, %s )", scrollVolume));
            System.out.println("Scrolling " + scrollVolume + " pixels down..");
            this.sleep(1);
        }
    }
    public abstract void openPage();
    public void navigateTo(String url){
        System.out.println("Navigating to URL: " + url);  // Debugging line
        this.driver.get(url);
    }
    public WebElement checkElement(String xpath) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Element not found" + xpath);
            return null;
        }
    }
}
