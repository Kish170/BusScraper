import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MBBot {
    WebDriver driver;
    List <TripResults> results = new ArrayList<>();
    List <String> MBCities = new ArrayList<String>();
    HashMap<String, String> cityIds = new HashMap<String, String>();

    public MBBot(WebDriver driver) {
        this.driver = driver;
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
    public void getCities() {
        this.driver.get("https://ca.megabus.com/stops");
        this.sleep(7);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"bx-close-inside-2488666\"]"));
        button.click();
        this.scrollOnPage(this.driver, 4, 500);

        List<WebElement> cityElements = driver.findElements(By.xpath("//h4/a"));

        for (WebElement cityElement : cityElements) {
            MBCities.add(cityElement.getText());
        }
        for (String city : MBCities) {
            System.out.println(city);
        }
    }

    public void getResults(String from, String to, int travelers) {
        this.driver.get("https://ca.megabus.com/");
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bx-close-inside-2488666\"]")));
        button.click();
        WebElement tripButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"homepageContentArea\"]/div[1]/mb-user-home/div/div/div/div/div/mb-journey-planner-lite/div/div/mb-journey-search/div/div/div/div/form/div[1]/div/fieldset/mb-radio-group/div[1]/label")));
        tripButton.click();
        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"startingAt\"]"));
        fromCity.sendKeys(from);
        this.sleep(2);
        actions.moveToElement(fromCity).sendKeys(Keys.ENTER).perform();
        WebElement toCity = driver.findElement(By.xpath("//*[@id=\"goingTo\"]"));
        toCity.sendKeys(to);
        this.sleep(2);
        actions.moveToElement(toCity).sendKeys(Keys.ENTER).perform();
        WebElement dateButton = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
        dateButton.click();
        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]/span[2]/span")));
        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[3]/td[7]/button/span[1]")));
        while (!month.getText().equals("APR 2025") && !day.getText().equals("1")) {
            actions.moveToElement(dateButton).sendKeys(Keys.ARROW_RIGHT).perform();
            month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]/span[2]/span")));
            day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[3]/td[7]/button/span[1]")));
        }
        actions.moveToElement(dateButton).sendKeys(Keys.ENTER).perform();
        WebElement incrementTravelers = driver.findElement(By.xpath("//*[@id=\"totalPassengers_plus\"]"));
        for (int i = 1; i < travelers; i++) {
            incrementTravelers.click();
        }
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"findTickets\"]"));
        searchButton.click();
        this.sleep(5);
    }
}
