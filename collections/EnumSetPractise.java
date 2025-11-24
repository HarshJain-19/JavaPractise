package collections;

import java.util.EnumSet;

public class EnumSetPractise {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    public static void main(String[] args) {

        System.out.println(Day.class);

        //no constructor, instance are created using factory methods
        EnumSet<Day> workDays = EnumSet.range(Day.TUESDAY, Day.FRIDAY);

        System.out.println("Work days in the range are:");
        for (Day day : workDays) {
            System.out.println(day);
        }

        EnumSet<Day> dayEnumSet1 = EnumSet.allOf(Day.class);
//        System.out.println(dayEnumSet1);

        EnumSet<Day> dayEnumSet2 = EnumSet.noneOf(Day.class);
//        dayEnumSet2.add(Day.SUNDAY);
//        System.out.println(dayEnumSet2);

        EnumSet<Day> dayEnumSet3 = EnumSet.of(Day.TUESDAY);
//        System.out.println(dayEnumSet3);

    }
}
