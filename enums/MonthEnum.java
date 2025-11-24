package enums;

import problems.problem1.Month;

public enum MonthEnum {
    JANUARY("1",31),
    FEBRUARY("2",28),
    MARCH("3",31),
    APRIL("4",30),
    MAY("5",31),
    JUNE("6",30),
    JULY("7",31),
    AUGUST("8",31),
    SEPTEMBER("9",30),
    OCTOBER("10",31),
    NOVEMBER("11",30),
    DECEMBER("12",31);

    private int days;
    private String monthNumber;

    MonthEnum(String monthNumber, int days) {
        this.monthNumber = monthNumber;
        this.days = days;
    }

    public int getDays() {
        return this.days;
    }

    public String getMonthNumber() {
        return this.monthNumber;
    }

    public void leapYear(boolean isLeapYear) {
        if (this == FEBRUARY)
            this.days = isLeapYear ? 29 : 28;
    }

    public static Month getMonthByNumber(String monthNumber) {
        switch (monthNumber) {
            case "1":
                return Month.JANUARY;
            case "2":
                return Month.FEBRUARY;
            case "3":
                return Month.MARCH;
            case "4":
                return Month.APRIL;
            case "5":
                return Month.MAY;
            case "6":
                return Month.JUNE;
            case "7":
                return Month.JULY;
            case "8":
                return Month.AUGUST;
            case "9":
                return Month.SEPTEMBER;
            case "10":
                return Month.OCTOBER;
            case "11":
                return Month.NOVEMBER;
            case "12":
                return Month.DECEMBER;
            default:
                throw new IllegalArgumentException("Invalid month number: "+monthNumber);
        }
    }
}
