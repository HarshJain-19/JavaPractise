package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimePractise {
    public static void main(String[] args) {

        // current date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current Date and Time: " + current);

        // LocalDateTime --> String
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("DD MM, YYYY hh:mm:ss a");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Date and Time: " + formattedCurrent);

    // LocalDate --> LocalDateTime
        // start of the day
        LocalDateTime sod = LocalDate.now().atStartOfDay();
        System.out.println("Start of the Day: " + sod);

    // LocalTime --> LocalDateTime
        LocalTime localTime1 = LocalTime.NOON;
        LocalDateTime localDateTime1 = LocalDate.now().atTime(localTime1);
        System.out.println("LocalDateTime from localTime: " + localDateTime1);

        // use plus/minus of both LocalDate/LocalTime

        // Milliseconds
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);

        // Minutes
        LocalDateTime localDateTime3 = LocalDateTime.of(2021, Month.APRIL, 24, 14, 33);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);

        // parse
        System.out.println("parsing: " + LocalDateTime.parse("31/10/2005 05:30:34-123456789 PM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss-n a")));
    }
}
