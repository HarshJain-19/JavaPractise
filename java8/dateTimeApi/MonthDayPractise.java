package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

public class MonthDayPractise {
    public static void main(String[] args) {
        MonthDay current = MonthDay.now();
        System.out.println("current monthDay: " + current);

        MonthDay monthDay1 = MonthDay.of(Month.MARCH, 14);
        System.out.println("specific: " + monthDay1);

        // MonthDay --> LocalDate
        LocalDate localDate = current.atYear(2023);
        System.out.println("atYear: " + localDate);

        // compareTo, isAfter and isBefor
        System.out.println("monthDay1.compareTo(current): " + monthDay1.compareTo(current));
        System.out.println("monthDay1.isAfter()(current): " + monthDay1.isAfter(current));
        System.out.println("monthDay1.isBefore()()(current): " + monthDay1.isBefore(current));

        // getter
        Month month = current.getMonth();
        int monthValue = current.getMonthValue();
        int day = current.getDayOfMonth();

        // with
        MonthDay monthDay2 = current.with(Month.APRIL);
        MonthDay monthDay3 = current.withMonth(1).withDayOfMonth(23);
    }
}
