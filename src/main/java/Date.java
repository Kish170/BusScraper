import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Date {
    public Date(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    @Override
    public String toString() {
        return formatDate();
    }
    private LocalDate date;
}
