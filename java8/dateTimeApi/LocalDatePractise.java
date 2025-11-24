package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDatePractise {
    public static void main(String[] args) {

        // current date
        LocalDate current = LocalDate.now();
        System.out.println("Current Date: " + current);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM, YYYY");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Date: " + formattedCurrent);

        // Parses the date
        LocalDate dt1 = LocalDate.parse("2021-01-07");
        LocalDate result = dt1.withDayOfYear(01);

        // Prints the date with year
        System.out.println("The date with day of year is: " + result);

        // Start of the day
        System.out.println("start of the day: " + current.atStartOfDay());

    }
}
