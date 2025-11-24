package problems.problem1;

import java.time.LocalDate;

public class Salary implements Comparable<Salary> {
    private float basic, HRA, PF, TDS;
    private String year;
    private Month month;
    private float penalty;

    public Salary(float basic) {
        this.basic = basic;
        this.month = Month.getMonthByNumber(String.valueOf(LocalDate.now().getMonthValue()));
        this.year = String.valueOf(LocalDate.now().getYear());
        calcSalaryStructure(basic);
        this.penalty=0;
    }

    public Salary(float basic, Month month, String year) {
        this.basic = basic;
        this.month = month;
        this.year = year;
        this.penalty = 0f;
        calcSalaryStructure(basic);
    }

    public Salary(Salary sal) {
        this.basic = sal.basic;
        this.month = sal.month;
        this.year = sal.year;
        this.penalty = sal.penalty;
        this.PF = sal.PF;
        this.TDS = sal.TDS;
        this.HRA = sal.HRA;
    }
    
    public Salary(float basic, Month month, String year, float penalty) {
        this.basic = basic;
        this.month = month;
        this.year = year;
        this.penalty = penalty;
        calcSalaryStructure(basic);
    }

    private void calcSalaryStructure(float basic) {
        this.HRA = basic*30/100;                //HRA is 30% of basic
        this.PF = basic*12/100;                 //PF is 12% of basic
        this.TDS = (basic+HRA-PF)*20/100;       //TDS is 20% of (basic+HRA-PF)
    }
    
    public float getBasic() {
        return basic;
    }

    public float getHRA() {
        return HRA;
    }

    public float getPF() {
        return PF;
    }

    public float getTDS() {
        return TDS;
    }

    public String getMonth() {
        return this.month.getMonthNumber();
    }

    public String getYear() {
        return year;
    }

    public float getPenalty() {
        return penalty;
    }

    public void setPenalty(float penalty) {
        this.penalty = penalty;
    }

    public float getTotalSalary() {
        return basic+HRA-PF-TDS;
    }

    public float getSalary() {
        int yearValue = Integer.parseInt(year);
        boolean isLeapYear = (yearValue % 400 == 0 || (yearValue % 4 == 0 && yearValue % 100 != 0));
        return getTotalSalary() - (penalty*getTotalSalary()/month.getDays(isLeapYear));
    }

    @Override
    public String toString() {
        return String.valueOf(getSalary());
    }

    @Override
    public int compareTo(Salary obj) {
        return (int) (this.getSalary()-obj.getSalary());
    }
}

