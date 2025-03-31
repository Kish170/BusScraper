import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MBSearchPage;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 4, 1);
        LocalDate retDate = LocalDate.of(2025, 5, 17);
        System.out.println(date);
        System.out.println("hello world");
        WebDriver driver = new ChromeDriver();
//        MBBot bot = new MBBot(driver);
//        bot.getCities();
//        bot.getResults("Toronto", "Belleville", 2);
        MBSearchPage searchPage = new MBSearchPage(driver);
        searchPage.searchTrip("Toronto", "Belleville", 2, date, retDate);
        driver.quit();
    }

}
