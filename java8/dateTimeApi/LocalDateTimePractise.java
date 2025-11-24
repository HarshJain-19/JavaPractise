package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimePractise {
    public static void main(String[] args) {

        // current date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current Date and Time: " + current);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("DD MM, YYYY");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Date and Time: " + formattedCurrent);

    }
}
