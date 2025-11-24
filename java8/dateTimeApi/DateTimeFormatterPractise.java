package java8.dateTimeApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterPractise {
    public static void main(String[] args) {

        // current date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current Date and Time: " + current);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy - hh:mm:ss a");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Date and Time: " + formattedCurrent);

        System.out.println("\nMore Formatted Dates: ");

        System.out.println(DateTimeFormatter.ofPattern("E, d MMM, YY - HH:mm:ss").format(current));
        System.out.println(DateTimeFormatter.ofPattern("e, d MMM, YY - HH:mm:ss | qqq").format(current));
            // `E` for day-of-week and `e` for localized day-of-week
        System.out.println(DateTimeFormatter.ofPattern("eee, d MMM, YY - kk:mm:ss | QQQQ").format(current));
            // `q` == `Q`
        System.out.println(DateTimeFormatter.ofPattern("eee, d MMM, YY - KK:mm:ss n | qq | F").format(current));
            // `F` stands for days of week in month
            // h for clock-hour-of-am-pm (1-12)
            // H for clock-hour-of-day (0-23)
            // k for clock-hour-of-day (1-24)
            // K for hour-of-am-pm (0-11)
            // n nanoseconds

    }
}
