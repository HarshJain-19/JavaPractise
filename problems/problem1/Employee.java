package problems.problem1;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class Employee implements Comparable<Employee> {
    final int id;
    private String firstName, lastName;
    private LocalDate DOB;
    private Address address;
    private EmployeeStatus status;
    private Map<String, Map<Month, Salary>> salaryMap;    //map(year, map(month, salary))
    private LocalDate dateOfJoining;
    private float leaveBalance;
    private TreeSet<LocalDate> leaveHistory;                 //list(leave dates)

    private final float LeavesPerMonth = 1.5f;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Employee(int id, String firstName, String lastName, String DOB, Address address, EmployeeStatus status, Map<String, Map<Month, Salary>> salaryMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = LocalDate.parse(DOB, dateFormat);
        this.address = address;
        this.status = status;
        this.salaryMap = salaryMap;
        this.dateOfJoining = LocalDate.now();
        this.leaveBalance = LeavesPerMonth;
        this.leaveHistory = new TreeSet<>();
    }
    public Employee(int id, String firstName, String lastName, String DOB, Address address, EmployeeStatus status, String dateOfJoining, Map<String, Map<Month, Salary>> salaryMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = LocalDate.parse(DOB, dateFormat);
        this.address = address;
        this.status = status;
        this.salaryMap = salaryMap;
        this.dateOfJoining = LocalDate.parse(dateOfJoining, dateFormat);
        this.leaveBalance = LeavesPerMonth;
        this.leaveHistory = new TreeSet<>();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " - " + id;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.getFullName().compareTo(emp.getFullName());
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB.format(dateFormat);
    }

    public void setDOB(String DOB) {
        this.DOB = LocalDate.parse(DOB, dateFormat);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Map<String, Map<Month, Salary>> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(Map<String, Map<Month, Salary>> salaryMap) {
        this.salaryMap = salaryMap;
    }

    public String getDateOfJoining() {
        return dateOfJoining.format(dateFormat);
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining, dateFormat);
    }

    public float getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(float leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public List<String> getLeaveHistory() {
        List<String> leaveHistoryString = new ArrayList<>();
        for (LocalDate leaveDate: leaveHistory) {
            leaveHistoryString.add(leaveDate.format(dateFormat));
        }
        return leaveHistoryString;
    }

    public void setLeaveHistory(List<String> leaveHistory) {
        TreeSet<LocalDate> leaveHistoryLocalDate = new TreeSet<>();
        for (String leaveDateString: leaveHistory) {
            leaveHistoryLocalDate.add(LocalDate.parse(leaveDateString,dateFormat));
        }
        this.leaveHistory = leaveHistoryLocalDate;
    }

    public boolean isOnLeaveToday() {
        LocalDate today = LocalDate.now();
        for (LocalDate leave: leaveHistory) {
            if (leave.equals(today))
                return true;
        }
        return false;
    }
    public boolean isOnLeave(String date) {
        LocalDate localDate = LocalDate.parse(date, dateFormat);
        for (LocalDate leave: leaveHistory) {
            if (leave.equals(localDate))
                return true;
        }
        return false;
    }

    public void applyLeave(String from, String to) {
        LocalDate fromLocal = LocalDate.parse(from, dateFormat);
        LocalDate toLocal = LocalDate.parse(to, dateFormat);

        if (fromLocal.isAfter(toLocal)) {
            throw new IllegalArgumentException("fromDate cannot be more than toDate while apply leave");
        }

        float totalAppliedLeaves = ChronoUnit.DAYS.between(fromLocal, toLocal);

        Scanner input = new Scanner(System.in);

        if (totalAppliedLeaves > leaveBalance) {
            float leaveDifference = totalAppliedLeaves - leaveBalance ;
            System.out.printf("Insufficient Leave Balance!\nTotal Leave Balance: %.1f\nApplied Leaves: %.1f\nExtra Leaves: %.1f\n", leaveBalance, totalAppliedLeaves, leaveDifference);
            System.out.printf("Do you want %.1f unpaid leave (Yes/No): ", leaveDifference);
            String userResponse = input.next();

            if ("Yes".equalsIgnoreCase(userResponse))
                leaveBalance = -leaveDifference;
            else
                return;
        } else
            leaveBalance -= totalAppliedLeaves;

        for (; fromLocal.isBefore(toLocal.plusDays(1)); fromLocal = fromLocal.plusDays(1)) {
            leaveHistory.add(fromLocal);
        }
    }
    public void applyLeave(String... datesArg) {

        float totalAppliedLeaves = datesArg.length;

        Scanner input = new Scanner(System.in);

        if (totalAppliedLeaves > leaveBalance) {
            float leaveDifference = totalAppliedLeaves - leaveBalance ;
            System.out.printf("Insufficient Leave Balance!\nTotal Leave Balance: %.1f\nApplied Leaves: %.1f\nExtra Leaves: %.1f", leaveBalance, totalAppliedLeaves, leaveDifference);
            System.out.print("Do you want %.1f unpaid leave (Yes/No): ");
            String userResponse = input.next();

            if ("Yes".equalsIgnoreCase(userResponse))
                leaveBalance = -leaveDifference;
            else
                return;
        } else
            leaveBalance -= totalAppliedLeaves;

        for (String date: datesArg) {
            leaveHistory.add(LocalDate.parse(date, dateFormat));
        }
    }

    public void monthEnd(Salary salary) {
        if (salary==null)
            salary = new Salary(0);
        LocalDate today = LocalDate.now();

        // for post date salary
        if (today.getYear()<Integer.parseInt(salary.getYear()) || (today.getYear()==Integer.parseInt(salary.getYear()) && today.getMonthValue()<Integer.parseInt(salary.getMonth())))
            throw new IllegalArgumentException("Salary can not be post credited!");

        //for salary before joining
        LocalDate salaryDate = LocalDate.of(Integer.parseInt(salary.getYear()), Integer.parseInt(salary.getMonth()), 1).plusMonths(1);
        if (salaryDate.isBefore(dateOfJoining))
            throw new IllegalArgumentException("Salary can not be pre credited (before joining)");

        //for salary on same month of joining
        if (dateOfJoining.getMonthValue() == Integer.parseInt(salary.getMonth())) {
            int dateDifference = dateOfJoining.lengthOfMonth() - dateOfJoining.getDayOfMonth() + 1;
            salary.setPenalty(salary.getPenalty() + dateDifference);
        }

        //for salary of same month
        if (today.getMonthValue() == Integer.parseInt(salary.getMonth())) {
            int daysLeft = today.lengthOfMonth()-today.getDayOfMonth();
            salary.setPenalty(salary.getPenalty() + daysLeft);
        }

        if (leaveBalance<0) {
            salary.setPenalty(salary.getPenalty() + (-leaveBalance));
            leaveBalance = 0;
        }
        leaveBalance += 1.5f;
        salaryMap.putIfAbsent(salary.getYear(), new HashMap<>());
        salaryMap.get(salary.getYear()).putIfAbsent(Month.getMonthByNumber(salary.getMonth()), salary);
    }
}
