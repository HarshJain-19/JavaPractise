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
            // `q` == `Q` = Quarter
        System.out.println(DateTimeFormatter.ofPattern("eee, d MMM, YY - KK:mm:ss n | qq | F").format(current));
            // `F` stands for days of week in month
            // h for clock-hour-of-am-pm (1-12)
            // H for clock-hour-of-day (0-23)
            // k for clock-hour-of-day (1-24)
            // K for hour-of-am-pm (0-11)
            // n nanoseconds

    /*
        Pattern	        Meaning	                Example Output
        yyyy            4-digit year	        2025
        MM              2-digit month	        04
        MMM             Short month name	    Apr
        dd              Day of month	        09
        EEEE            Day of week (full)	    Tuesday
        E               Day of week (abbr)	    Tue
        HH              Hour (0-23)	            17
        hh              Hour (1-12, am/pm)	    05
        mm              Minutes	                59
        ss              Seconds	                02
        a               AM/PM	                PM
        z               Time zone name	        PST
        Z               Time zone offset	    -0800
        SSS             Milliseconds	        123
        XX/XXX          Zone offset	            +08:00
    */

        // constants
        System.out.println("DateTimeFormatter.ISO_DATE: " + DateTimeFormatter.ISO_DATE);
        System.out.println("DateTimeFormatter.ISO_LOCAL_TIME: " + DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("DateTimeFormatter.ISO_LOCAL_DATE: " + DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("DateTimeFormatter.ISO_DATE_TIME: " + DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("DateTimeFormatter.ISO_INSTANT: " + DateTimeFormatter.ISO_INSTANT);
        System.out.println("DateTimeFormatter.BASIC_ISO_DATE: " + DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("DateTimeFormatter.ISO_ZONED_DATE_TIME: " + DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println("DateTimeFormatter.ISO_ORDINAL_DATE: " + DateTimeFormatter.ISO_ORDINAL_DATE);
    }
}
