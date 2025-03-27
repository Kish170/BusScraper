package composites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class CustomDate {
    public CustomDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", java.util.Locale.ENGLISH);
        return date.format(formatter);
    }
    public int getDay() {
        return date.getDayOfMonth();
    }
    public int dayOfWeek() {
        return date.getDayOfWeek().getValue();
    }
    @Override
    public String toString() {
        return formatDate();
    }
    private LocalDate date;
}
