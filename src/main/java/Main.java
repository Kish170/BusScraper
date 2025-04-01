import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MBSearchPage;
import java.time.LocalDate;
import pages.FBSearchPage;
import pages.VRSearchPage;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 6, 2);
        LocalDate retDate = LocalDate.of(2025, 7, 17);
        System.out.println(date);
        System.out.println("hello world");
        WebDriver driver = new ChromeDriver();
//        MBBot bot = new MBBot(driver);
//        bot.getCities();
//        bot.getResults("Toronto", "Belleville", 2);
//        MBSearchPage searchPage = new MBSearchPage(driver);
//        searchPage.searchTrip("Toronto", "Belleville", 2, date, retDate);
//        FBSearchPage searchPage = new FBSearchPage(driver);
//        searchPage.searchTrip("Toronto", "Belleville", 2, 0, 0, 0, date, retDate);
        VRSearchPage searchPage = new VRSearchPage(driver);
        searchPage.searchTrip("Toronto", "Belleville", 2, 0, 0, 0, 0, date);

        driver.quit();
    }

}
