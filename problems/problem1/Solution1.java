package problems.problem1;

import java.sql.SQLOutput;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
    //addresses
        Address address1 = new Address(505, "Toronto", "Ontario", "Canada", 12345);
        Address address2 = new Address(606, "Vancouver", "British Columbia", "Canada", 67890);
        Address address3 = new Address(707, "London", "England", "UK", 10101);
        Address address4 = new Address(808, "Paris", "Île-de-France", "France", 20202);
        Address address5 = new Address(909, "Berlin", "Berlin", "Germany", 30303);

    //salaries
        Salary salary1 = new Salary(5000.75f, Month.JANUARY, "2024");
        Salary salary2 = new Salary(5200.50f, Month.FEBRUARY, "2024");
        Salary salary3 = new Salary(7000.00f, Month.OCTOBER, "2024");
        Salary salary4 = new Salary(6000.00f, Month.APRIL, "2024");
        Salary salary5 = new Salary(7500.50f, Month.NOVEMBER, "2023");
        Salary salary6 = new Salary(8000.75f, Month.DECEMBER, "2023");
        Salary salary7 = new Salary(6500.20f, Month.MAY, "2023");
        Salary salary8 = new Salary(5500.30f, Month.MARCH, "2024");
        Salary salary9 = new Salary(7300.80f, Month.JULY, "2024");
        Salary salary10 = new Salary(7600.90f, Month.AUGUST, "2023");
        Salary salary11 = new Salary(6900.50f, Month.SEPTEMBER, "2023");
        Salary salary12 = new Salary(6800.60f, Month.JULY, "2024");
        Salary salary13 = new Salary(7200.30f, Month.AUGUST, "2024");
        Salary salary14 = new Salary(7400.40f, Month.SEPTEMBER, "2023");
        Salary salary15 = new Salary(7800.00f, Month.OCTOBER, "2024");
        Salary salary16 = new Salary(7900.20f, Month.NOVEMBER, "2023");
        Salary salary17 = new Salary(8100.10f, Month.DECEMBER, "2024");
        Salary salary18 = new Salary(8500.75f, Month.MAY, "2023");
        Salary salary19 = new Salary(8800.65f, Month.JUNE, "2024");

        Salary salary20 = new Salary(8500.65f, Month.JANUARY, "2024");
        Salary salary21 = new Salary(10000.23f, Month.JANUARY, "2024");
        Salary salary22 = new Salary(15000.11f, Month.JANUARY, "2024");
        Salary salary23 = new Salary(20000.45f, Month.JANUARY, "2024");
        Salary salary24 = new Salary(30000.67f, Month.JANUARY, "2024");

    //salaryMaps
        Map<String, Map<Month, Salary>> salaryMap1 = OperationsOnEmployee.createSalaryMap(salary3, salary7, salary8, salary1, salary10, salary19, salary20, salary13, salary23);
        Map<String, Map<Month, Salary>> salaryMap2 = OperationsOnEmployee.createSalaryMap(salary1, salary2, salary3, salary5, salary16, salary8, salary3, salary21);
        Map<String, Map<Month, Salary>> salaryMap3 = OperationsOnEmployee.createSalaryMap(salary3, salary9, salary13, salary17, salary20, salary17, salary1);
        Map<String, Map<Month, Salary>> salaryMap4 = OperationsOnEmployee.createSalaryMap(salary2, salary4, salary6, salary8, salary10, salary12, salary14, salary16, salary18, salary24);
        Map<String, Map<Month, Salary>> salaryMap5 = OperationsOnEmployee.createSalaryMap(salary19, salary12, salary5, salary6, salary7, salary11, salary15, salary19, salary1, salary22);

    //employees list
        Employee emp1 = new Employee(1, "Mark", "Joe", "10/05/2000", new Address(address3), EmployeeStatus.REGULAR, salaryMap1);
        Employee emp2 = new Employee(2, "Anna", "Smith", "15/08/1995", new Address(address3), EmployeeStatus.ACTIVE, salaryMap1);
        Employee emp3 = new Employee(3, "John", "Doe", "22/03/1988", new Address(address1), EmployeeStatus.INACTIVE, salaryMap3);
        Employee emp4 = new Employee(4, "Sarah", "Lee", "30/07/1990", new Address(address5), EmployeeStatus.REGULAR, salaryMap4);
        Employee emp5 = new Employee(5, "David", "Brown", "05/12/1985", new Address(address5), EmployeeStatus.RESIGNED, salaryMap5);
        Employee emp6 = new Employee(6, "Emily", "Davis", "25/06/1992", new Address(address3), EmployeeStatus.REGULAR, salaryMap1);
        Employee emp7 = new Employee(7, "Mark", "Martinez", "18/04/1987", new Address(address2), EmployeeStatus.ACTIVE, salaryMap2);
        Employee emp8 = new Employee(8, "Anna", "Garcia", "30/10/1989", new Address(address1), EmployeeStatus.ACTIVE, salaryMap3);
        Employee emp9 = new Employee(9, "Ethan", "Hernandez", "12/02/1990", new Address(address4), EmployeeStatus.RESIGNED, salaryMap4);
        Employee emp10 = new Employee(10, "Anna", "Lopez", "07/09/1985", new Address(address5), EmployeeStatus.REGULAR, salaryMap5);

    //Employee List
        List<Employee> employeeList = OperationsOnEmployee.removeDuplicateEmployeesFromList(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp10));
        System.out.println(employeeList);

        //Ques.1 Find all employee live in same city, same country
        System.out.println("\nEmployees live in same city and country: ");
        OperationsOnEmployee.employeeLiveInSameCityAndCountry(employeeList);

        //Ques.2 Find sum of salary of every employee monthly
        System.out.println("\nEvery Employee Salary sum: ");
        OperationsOnEmployee.getTotalMonthlySalaryExpense(employeeList);

        //Ques.3.1 Sort Employee by first name and last name
        System.out.println("\nSorted Employee by name: ");
        Collections.sort(employeeList);
        System.out.println(employeeList);

        //Ques.3.2 Sort Employee by address
        System.out.println("\nSorted employee by address: ");
//        OperationsOnEmployee.sortByAddress(employeeList, "houseNumber");
        OperationsOnEmployee.sortByAddress(employeeList);
        OperationsOnEmployee.printEmployeeByNameAndAddress(employeeList);

        //Ques.4 Print PaySlip Month wise
        System.out.println("\nEmployee salary pay slip: ");
        OperationsOnEmployee.printPaySlipByMonth(emp2, "2024", Month.AUGUST);

        //Ques.5 Find the average salary of every employee yearly
        System.out.println("\nAverage salary of every employee yearly: ");
        OperationsOnEmployee.getAverageSalaryOfEveryEmployeeYearly(employeeList);

        //Ques.6 Find average salary of country wise
        System.out.println("\naverage salary country wise: ");
        OperationsOnEmployee.getAverageSalaryCountryWise(employeeList);

        //Ques.7 Find 5 maximum employee salary
        System.out.println("\n5 maximum employee salary: ");
        OperationsOnEmployee.get5EmployeeWithMaxSalary(employeeList, Month.JANUARY, "2024");

        //Ques.8 Find All Employee by status
        System.out.println("\nAll employees by status: ");
        OperationsOnEmployee.getEmployeesByStatus(employeeList).entrySet().forEach(System.out::println);

        //Ques.9 every month 1.5 leaves add on employee
        //Ques.10 employee will be able to take leave out of available leaves
        //Ques.12 show how many leaves are remaining
        //Ques.13 calc the salary after leave taken


        Employee emp11 = new Employee(11, "Kabir", "Das", "01/01/2001",  address4, EmployeeStatus.REGULAR, "15/10/2024", new HashMap<>());

        System.out.println("\n---employee onboarded (15 oct, 2024)---");
        System.out.println("leave balance: " + emp11.getLeaveBalance());
        System.out.println("salary map: " + emp11.getSalaryMap());

        System.out.println("\n---after month end (october)---");
        emp11.monthEnd(new Salary(15000, Month.OCTOBER, "2024"));
        System.out.println("leave balance: " + emp11.getLeaveBalance());
        System.out.println("salary map: " + emp11.getSalaryMap());

        System.out.println("\n---after month end (november)---");
        emp11.applyLeave("12/11/2024");
        emp11.monthEnd(new Salary(15000, Month.NOVEMBER, "2024"));
        System.out.println("leave balance after 1 leave applied: " + emp11.getLeaveBalance());
        System.out.println("salary map: " + emp11.getSalaryMap());

        System.out.println("\nApplying 6 days leave");
        emp11.applyLeave("02/12/2024", "08/12/2024");

        System.out.println("\n--after month end (december)");
        emp11.monthEnd(new Salary(15000, Month.DECEMBER, "2024"));
        System.out.println("leave balance after 6 leave applied: " + emp11.getLeaveBalance());
        System.out.println("salary map: " + emp11.getSalaryMap());

        employeeList.add(emp11);

        //Ques.11 show how many employee on leave today
        System.out.println("\nEmployees on leave today: " + OperationsOnEmployee.listOfEmployeeOnLeaveToday(employeeList));

        //Ques.14 maintain the history of employee leaves
        System.out.println("\nLeave History of " + emp11 + ": " + emp11.getLeaveHistory());

        //Ques.15 Show the count of Employees Status wise
        System.out.println("\nEmployees count by status: ");
        OperationsOnEmployee.getEmployeeCountByStatus(employeeList).entrySet().forEach(System.out::println);


    }
}
