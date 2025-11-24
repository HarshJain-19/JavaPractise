package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class LocalTimePractise {
    public static void main(String[] args) {
        // current time
        LocalTime current = LocalTime.now();
        System.out.println("Current Time: " + current);

        // formatting
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedCurrent = dateTimeFormatter.format(current);
        System.out.println("Formatted Time: " + formattedCurrent);

        // enums
        LocalTime localTime1 = LocalTime.MIDNIGHT;
        LocalTime localTime2 = LocalTime.NOON;
        LocalTime localTime3 = LocalTime.MAX;
        LocalTime localTime4 = LocalTime.MIN;

        // parse
        LocalTime dt1 = LocalTime.parse("01:23:45.34");
        LocalTime dt2 = LocalTime.parse("12-23-55 234, PM", DateTimeFormatter.ofPattern("hh-mm-ss n, a"));
        System.out.format("LocalTime by parsing (01:23:45.34): %s and (12-23-55 234): %s\n", dt1, dt2);

        // getters
        int hours = current.getHour();
        int minute = current.getMinute();
        int second = current.getSecond();
        int nanos = current.getNano();
        int nanoOfDay = current.get(ChronoField.MICRO_OF_SECOND);
    }
}
