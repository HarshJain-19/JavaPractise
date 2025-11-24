package problems.project2.service;

import problems.project2.model.*;
import problems.project2.model.Month;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public final class EmployeeOperations {
    private EmployeeOperations() {}

    public static void printDetails(Employee emp) {
        System.out.printf("Full name: %s \nId: %d \nDOB: %s \nAddress: %s \nStatus: %s \nbase salary: %.2f \ndate of joining: %s \nleave balance: %.1f", emp.getFullName(), emp.getId(), emp.getDOB(), emp.getAddress().fullAddress(), emp.getStatus(), emp.getBaseSalary(), emp.getDateOfJoining(), emp.getLeaveBalance());
    }

    public static void incrementSalary(Employee emp, float margin) {
        emp.setBaseSalary(emp.getBaseSalary() + (emp.getBaseSalary()*margin/100));
    }

    public static void decrementSalary(Employee emp, float margin) {
        emp.setBaseSalary(emp.getBaseSalary() - (emp.getBaseSalary()*margin/100));
    }

    public static boolean isOnLeaveToday(Employee emp) {
        String today = LocalDate.now().format(Employee.dateFormat);
        return emp.getLeaveHistory().stream().anyMatch(today::equals);
    }

    public static boolean isOnLeave(Employee emp, String date) {
        return emp.getLeaveHistory().stream().anyMatch(date::equals);
    }

    public static void applyLeave(Employee emp, String from, String to) {
        LocalDate fromLocal = LocalDate.parse(from, Employee.dateFormat);
        LocalDate toLocal = LocalDate.parse(to, Employee.dateFormat);

        if (fromLocal.isAfter(toLocal)) {
            throw new IllegalArgumentException("fromDate cannot be more than toDate while apply leave");
        }

        float totalAppliedLeaves = ChronoUnit.DAYS.between(fromLocal, toLocal) + 1;

        Scanner input = new Scanner(System.in);

        if (totalAppliedLeaves > emp.getLeaveBalance()) {
            float leaveDifference = totalAppliedLeaves - emp.getLeaveBalance();
            System.out.printf("Insufficient Leave Balance!\nTotal Leave Balance: %.1f\nApplied Leaves: %.1f\nExtra Leaves: %.1f\n", emp.getLeaveBalance(), totalAppliedLeaves, leaveDifference);
            System.out.printf("Do you want %.1f unpaid leave (Yes/No): ", leaveDifference);
            String userResponse = input.next();

            if (!"Yes".equalsIgnoreCase(userResponse))
                return;
        }
        emp.setLeaveBalance(emp.getLeaveBalance() - totalAppliedLeaves);

        List<String> leaveDates = emp.getLeaveHistory();
        for (; fromLocal.isBefore(toLocal.plusDays(1)); fromLocal = fromLocal.plusDays(1)) {
            leaveDates.add(fromLocal.format(Employee.dateFormat));
        }

        emp.setLeaveHistory(leaveDates);
        System.out.println("Leave applied successfuly!");
    }

    public static void applyLeave(Employee emp, List<String> leaveDates) {
        float totalAppliedLeaves = leaveDates.size();

        Scanner input = new Scanner(System.in);

        if (totalAppliedLeaves > emp.getLeaveBalance()) {
            float leaveDifference = totalAppliedLeaves - emp.getLeaveBalance();
            System.out.printf("Insufficient Leave Balance!\nTotal Leave Balance: %.1f\nApplied Leaves: %.1f\nExtra Leaves: %.1f", emp.getLeaveBalance(), totalAppliedLeaves, leaveDifference);
            System.out.print("Do you want %.1f unpaid leave (Yes/No): ");
            String userResponse = input.next();

            if (!"Yes".equalsIgnoreCase(userResponse))
                return;
        }
        emp.setLeaveBalance(emp.getLeaveBalance() - totalAppliedLeaves);

        List<String> leaveDatesFromHistory = emp.getLeaveHistory();
        leaveDatesFromHistory.addAll(leaveDates);
        emp.setLeaveHistory(leaveDatesFromHistory);

        System.out.println("Leave applied successfuly!");
    }

    public static void paySalary(Employee emp) {
        LocalDate today = LocalDate.now();
        LocalDate dateOfJoining = LocalDate.parse(emp.getDateOfJoining(), Employee.dateFormat);
        int month = today.getMonthValue(), year = today.getYear();
        float penalty = 0f;

        //for salary on same month of joining
        if (dateOfJoining.getYear() == year && dateOfJoining.getMonthValue() == month) {
            penalty += dateOfJoining.getDayOfMonth() - 1;
        }

        if (emp.getLeaveBalance() < 0)
            penalty += -emp.getLeaveBalance();
        emp.setLeaveBalance(Employee.LeavesPerMonth);

        Salary salary = new Salary(emp.getBaseSalary(), emp, penalty);
        emp.getSalaryMap().putIfAbsent(String.valueOf(today.getYear()), new TreeMap<>());
        emp.getSalaryMap().get(String.valueOf(today.getYear())).put(Month.getMonthByNumber(String.valueOf(today.getMonthValue())), salary);
    }

    public static void paySalary(Employee emp, String yearValue, String monthValue) {
        LocalDate today = LocalDate.now();
        LocalDate dateOfJoining = LocalDate.parse(emp.getDateOfJoining(), Employee.dateFormat);
        int month = Integer.parseInt(monthValue), year = Integer.parseInt(yearValue);
        float penalty = 0f;

        if (month>12 || month<1)
            throw new IllegalArgumentException("Invalid month!");

        // for post date salary
        if (today.getYear() < year || (today.getYear() == year && today.getMonthValue() < month))
            throw new IllegalArgumentException("Salary can not be post credited!");

        //for salary before joining
        LocalDate salaryDate = LocalDate.of(year, month, 1).plusMonths(1);
        if (salaryDate.isBefore(dateOfJoining))
            throw new IllegalArgumentException("Salary can not be pre credited (before joining)");

        //for salary on same month of joining
        if (dateOfJoining.getYear() == year && dateOfJoining.getMonthValue() == month) {
            penalty += dateOfJoining.getDayOfMonth() - 1;
        }

//        //for salary of current month
//        if (today.getYear() == year && today.getMonthValue() == month) {
//            penalty += today.lengthOfMonth() - today.getDayOfMonth();
//        }

        if (emp.getLeaveBalance() < 0)
            penalty += -emp.getLeaveBalance();

        emp.setLeaveBalance(emp.getLeaveBalance()<0 ? Employee.LeavesPerMonth : emp.getLeaveBalance()+1.5f);

        Salary salary = new Salary(emp.getBaseSalary(), emp, yearValue, monthValue, penalty);
        emp.getSalaryMap().putIfAbsent(yearValue, new TreeMap<>());
        emp.getSalaryMap().get(yearValue).put(Month.getMonthByNumber(monthValue), salary);
    }

    public static void paySalary(Employee emp, String yearValue, String monthValue, float basic) {
        LocalDate today = LocalDate.now();
        LocalDate dateOfJoining = LocalDate.parse(emp.getDateOfJoining(), Employee.dateFormat);
        int month = Integer.parseInt(monthValue), year = Integer.parseInt(yearValue);
        float penalty = 0f;

        if (month>12 || month<1)
            throw new IllegalArgumentException("Invalid month!");

        // for post date salary
        if (today.getYear() < year || (today.getYear() == year && today.getMonthValue() < month))
            throw new IllegalArgumentException("Salary can not be post credited!");

        //for salary before joining
        LocalDate salaryDate = LocalDate.of(year, month, 1).plusMonths(1);
        if (salaryDate.isBefore(dateOfJoining))
            throw new IllegalArgumentException("Salary can not be pre credited (before joining)");

        //for salary on same month of joining
        if (dateOfJoining.getYear() == year && dateOfJoining.getMonthValue() == month) {
            penalty += dateOfJoining.getDayOfMonth() - 1;
        }

//        //for salary of current month
//        if (today.getYear() == year && today.getMonthValue() == month) {
//            penalty += today.lengthOfMonth() - today.getDayOfMonth();
//        }

        if (emp.getLeaveBalance() < 0)
            penalty += -emp.getLeaveBalance();

        emp.setLeaveBalance(emp.getLeaveBalance()<0 ? Employee.LeavesPerMonth : emp.getLeaveBalance()+1.5f);

        Salary salary = new Salary(basic, emp, yearValue, monthValue, penalty);
        emp.getSalaryMap().putIfAbsent(yearValue, new TreeMap<>());
        emp.getSalaryMap().get(yearValue).put(Month.getMonthByNumber(monthValue), salary);
    }
}

