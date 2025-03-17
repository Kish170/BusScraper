import locators.MegabusLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2021, 10, 10);
        System.out.println(date);
        System.out.println("hello world");
        WebDriver driver = new ChromeDriver();
//        MBBot bot = new MBBot(driver);
//        bot.getCities();
//        bot.getResults("Toronto", "Belleville", 2);
        SearchPage searchPage = new SearchPage(driver, new MegabusLocators());
        searchPage.searchTrip("Toronto", "Belleville", 2);
        driver.quit();
    }

}
