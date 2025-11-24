package problems.project2.model;

import java.time.LocalDate;

public class Salary implements Comparable<Salary> {
    private float basic, HRA, PF, TDS;
    private String year;
    private Month month;
    private float penalty;
    private Employee employee;

    public Salary(float basic, Employee emp) {
        this.basic = basic;
        this.month = Month.getMonthByNumber(String.valueOf(LocalDate.now().getMonthValue()));
        this.year = String.valueOf(LocalDate.now().getYear());
        calcSalaryStructure(basic);
        this.penalty=0f;
        this.employee = emp;
    }

    public Salary(float basic, Employee emp, float penalty) {
        this.basic = basic;
        this.month = Month.getMonthByNumber(String.valueOf(LocalDate.now().getMonthValue()));
        this.year = String.valueOf(LocalDate.now().getYear());
        calcSalaryStructure(basic);
        this.penalty = penalty;
        this.employee = emp;
    }

    public Salary(float basic, Employee emp, String year, String month) {
        this.basic = basic;
        this.employee = emp;
        this.month = Month.getMonthByNumber(month);
        this.year = year;
        this.penalty = 0f;
        calcSalaryStructure(basic);
    }

    public Salary(float basic, Employee emp, String year, String month, float penalty) {
        this.basic = basic;
        this.employee = emp;
        this.month = Month.getMonthByNumber(month);
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

    public void setBasic(float basic) {
        this.basic = basic;
        calcSalaryStructure(basic);
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

    public void setMonth(String month) {
        this.month = Month.getMonthByNumber(month);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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


