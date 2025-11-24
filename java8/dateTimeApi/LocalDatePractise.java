package java8.dateTimeApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public class LocalDatePractise {
    public static void main(String[] args) {

        // current date
        LocalDate current = LocalDate.now();
        System.out.println("Current Date: " + current);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Date: " + formattedCurrent);

        // Parses the date
        LocalDate dt1 = LocalDate.parse("2021-01-07");
        LocalDate dt2 = LocalDate.parse("07/11/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.format("LocalDate by parsing (2021-01-07): %s and (07/11/2023): %s\n", dt1, dt2);
        LocalDate result = dt1.withDayOfYear(01);

        // Prints the date with year
        System.out.println("The date with day of year is: " + result);

        // Start of the day
        System.out.println("start of the day: " + current.atStartOfDay());

        // 'of'
        LocalDate localDate1 = LocalDate.of(2025, 3, 23);
        LocalDate localDate2 = LocalDate.of(2025, Month.MARCH, 23);
        System.out.printf("using of %s and %s\n", localDate1, localDate2);

        // plus and minus days
        System.out.format("localDate plus days: %s\n", current.plusDays(2));
        System.out.format("localDate plus month: %s\n", current.plusMonths(1));
        System.out.format("localDate plus weeks: %s\n", current.plusWeeks(3));
        System.out.format("localDate plus year: %s\n", current.plusYears(-1));

        System.out.format("localDate minus days: %s\n", current.minusDays(2));
        System.out.format("localDate minus month: %s\n", current.minusMonths(1));
        System.out.format("localDate minus weeks: %s\n", current.minusWeeks(3));
        System.out.format("localDate minus year: %s\n", current.minusYears(-1));

        System.out.format("Using normal plusDays: %s\n", current.plus(2, ChronoUnit.DECADES));

        // epoc
        System.out.println("epoc localDate: " + LocalDate.ofEpochDay(1_000));

        // getter
        DayOfWeek dayOfWeek = current.getDayOfWeek();
        int dayOfMonth = current.getDayOfMonth();
        int dayOfYear = current.getDayOfYear();
        Month month = current.getMonth();
        int monthValue = current.getMonthValue();
        int year = current.getYear();

        // with
        System.out.println("with: " + current.withDayOfMonth(12).withMonth(12).withYear(2022));
        System.out.println("with temporal: " + current.with(ChronoField.DAY_OF_WEEK, 3));

    }
}
