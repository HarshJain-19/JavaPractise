package problems.project2.model;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class Employee implements Comparable<Employee> {
    private final int id;
    private String firstName, lastName;
    private LocalDate DOB;
    private Address address;
    private EmployeeStatus status;
    private float baseSalary;
    private TreeMap<String, TreeMap<Month, Salary>> salaryMap;    //map(year, map(month, salary))
    private LocalDate dateOfJoining;
    private float leaveBalance;
    private TreeSet<LocalDate> leaveHistory;                //list(leave dates)

    public static final float LeavesPerMonth = 1.5f;
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Employee(int id, String firstName, String lastName, String DOB, Address address, EmployeeStatus status, float baseSalary) throws DateTimeParseException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = LocalDate.parse(DOB, dateFormat);
        this.address = address;
        this.status = status;
        this.baseSalary = baseSalary;
        this.salaryMap = new TreeMap<>(Comparator.reverseOrder());
        this.dateOfJoining = LocalDate.now();
        this.leaveBalance = LeavesPerMonth;
        this.leaveHistory = new TreeSet<>(Comparator.reverseOrder());
    }

    public Employee(int id, String firstName, String lastName, String DOB, Address address, EmployeeStatus status, float baseSalary, String dateOfJoining) throws DateTimeParseException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = LocalDate.parse(DOB, dateFormat);
        this.address = address;
        this.status = status;
        this.baseSalary = baseSalary;
        this.salaryMap = new TreeMap<>(Comparator.reverseOrder());
        this.dateOfJoining = LocalDate.parse(dateOfJoining, dateFormat);
        this.leaveBalance = LeavesPerMonth;
        this.leaveHistory = new TreeSet<>(Comparator.reverseOrder());
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

    public TreeMap<String, TreeMap<Month, Salary>> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(TreeMap<String, TreeMap<Month, Salary>> salaryMap) {
        this.salaryMap = salaryMap;
    }

    public String getDateOfJoining() {
        return dateOfJoining.format(dateFormat);
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining, dateFormat);
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(float leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public List<String> getLeaveHistory() {
        List<String> leaveHistoryString = new LinkedList<>();
        for (LocalDate leaveDate : leaveHistory) {
            leaveHistoryString.add(leaveDate.format(dateFormat));
        }
        return leaveHistoryString;
    }

    public void setLeaveHistory(List<String> leaveHistory) {
        TreeSet<LocalDate> leaveHistoryLocalDate = new TreeSet<>(Comparator.reverseOrder());
        for (String leaveDateString : leaveHistory) {
            leaveHistoryLocalDate.add(LocalDate.parse(leaveDateString, dateFormat));
        }
        this.leaveHistory = leaveHistoryLocalDate;
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
        return this.toString().compareTo(emp.toString());
    }
}

