package pages;

import locators.LocatorsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.YearMonth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import composites.CustomDate;

public class SearchPage extends BasePage {
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

        WebElement tripButton = checkElement(locator.getOneWayButton());
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
/*        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
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
        actions.moveToElement(dateButton).sendKeys(Keys.ENTER).perform();*/
        setDate(dateButton, date);
        for (int i = 1; i < travelers; i++) {
            incrementTravelers.click();
        }
        searchButton.click();
        this.sleep(5);
    }
    public void searchTrip(String from, String to, int travelers, CustomDate date, CustomDate returnDate) {
        openPage();
        WebElement closeButton = checkElement(locator.getCloseButton());
        closeButton.click();

        WebElement tripButton = checkElement(locator.getRoundTripButton());
        WebElement fromCity = checkElement(locator.getFromInput());
        WebElement toCity = checkElement(locator.getToInput());
        WebElement dateButton = checkElement(locator.getDateButton());
        WebElement retDateButton = checkElement(locator.getReturnDateButton());
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
        setDate(dateButton, date);
        retDateButton.click();
        setDate(retDateButton, returnDate);
        for (int i = 1; i < travelers; i++) {
            incrementTravelers.click();
        }
        searchButton.click();
        this.sleep(5);
    }

    public void setDate (WebElement dateButton, CustomDate date) {
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

        //find today's date
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int monthInt = today.getMonthValue();
        int dayInt = 1;

        //find the first day of the month
        LocalDate firstDate = LocalDate.of(year, monthInt, dayInt);
        DayOfWeek dayOfWeek = firstDate.getDayOfWeek();

        //find how many rows in calendar
        int td = 0;
        if (dayOfWeek.getValue() > 4) {
            td = 6;
        } else {
            td = 5;
        }
        System.out.println("rows: " + td);

        //find how many days in the month
        YearMonth yearMonth = YearMonth.of(year, monthInt);
        int daysInMonth = yearMonth.lengthOfMonth();

        //find how many days are in the first row
        int findtd = 8 - dayOfWeek.getValue();

        if (today.getDayOfMonth() <= findtd) { //if today is in the first row
            td = 1;
        } else { //if today is in any other row
            // Remaining days after the first row
            int remainingDays = today.getDayOfMonth() - findtd;

            // Each full row contains 7 days
            td = 1 + (int) Math.ceil(remainingDays / 7.0);
        }
        int tr = today.getDayOfWeek().getValue() + 1;
        System.out.println("td: " + td + " tr: " + tr);
        String dayText = locator.getDay();
        System.out.println(dayText);

        pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");
        matcher = pattern.matcher(dayText);
        if (matcher.find()) {
            String firstNumber = matcher.group(1);
            String secondNumber = matcher.group(3);

            dayText = dayText.replaceFirst(firstNumber, String.valueOf(td)).replaceFirst(secondNumber, String.valueOf(tr));
        }
        System.out.println(dayText);
        WebElement day = checkElement(dayText);
        while (!month.getText().startsWith(monthStr) && !day.getText().equals(dayStr)) {
            actions.moveToElement(dateButton).sendKeys(Keys.ARROW_RIGHT).perform();
            month = checkElement(locator.getMonthYear());
            day = checkElement(locator.getDay());
        }
        actions.moveToElement(dateButton).sendKeys(Keys.ENTER).perform();
    }
}
