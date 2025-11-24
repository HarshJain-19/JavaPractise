package enums;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

public class enumsPractise1 {
    Day day;

    public enumsPractise1(Day day) {
        this.day = day;
    }

    public void dayIsLike() {
        switch (day) {
            case MONDAY:
                System.out.println("Its Monday");
                break;
            case TUESDAY:
                System.out.println("Its Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Its Wednesday");
                break;
            case THURSDAY:
                System.out.println("Its Thursday");
                break;
            case FRIDAY:
                System.out.println("Its Friday");
                break;
            default:
                System.out.println("Its Weekend");
        }
    }

    public static void main(String[] args) {
        Day d1 = Day.MONDAY;
        new enumsPractise1(d1).dayIsLike();

        //loop
        for(Day d: Day.values()) {
            System.out.println(d);
        }
        
    }
}
