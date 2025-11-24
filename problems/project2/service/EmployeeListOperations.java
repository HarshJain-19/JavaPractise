package problems.project2.service;

import problems.project2.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.*;

public class EmployeeListOperations {
    private Set<Employee> employees;

    public EmployeeListOperations(Set<Employee> employees) {
        this.employees = employees;
    }

    public void printAllEmployees() {
        System.out.println(employees);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeByID(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void printEmployeesByNameAndAddress(List<Employee> empList) {
        empList.forEach(emp -> {
            System.out.println(emp.getFullName() + " - " + emp.getAddress());
        });
    }

    public void printByAddress() {

//        List<Employee> empList = employees.stream()
//                .sorted(Comparator.comparing((Employee employee) -> employee.getAddress().getCountry())
//                        .thenComparing((Employee employee) -> employee.getAddress().getState())
//                        .thenComparing((Employee employee) -> employee.getAddress().getCity())
//                        .thenComparing((Employee employee) -> employee.getAddress().getHouseNumber())
//                ).collect(Collectors.toList());

        List<Employee> empList = new ArrayList<>(employees);
        empList.sort(new CompareEmployeeByAddress());
        printEmployeesByNameAndAddress(empList);
    }

    public void printByAddress(String by) {
        List<Employee> empList = new ArrayList<>(employees);
        empList.sort(new CompareEmployeeByAddress(by));
        printEmployeesByNameAndAddress(empList);
    }

    public void employeeLiveInSameCityAndCountry() {
        //making map
        Map<String, List<Employee>> sameCityAndCountryEmployeeMap = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getAddress().getCity() + ", " + emp.getAddress().getCountry()));

        //printing result
        sameCityAndCountryEmployeeMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    String address = entry.getKey();
                    List<Employee> employees = entry.getValue();
                    System.out.println(employees + " lives in " + address);
                });
    }

    public void printPaySlipByMonth(Employee emp, String year, String monthValue) {
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        Month month = Month.getMonthByNumber(monthValue);
        Map<Month, Salary> salaryByYear = emp.getSalaryMap().get(year);

        if (salaryByYear == null)
            System.out.println("Salary not found for this year: " + year);
        else {
            Salary salaryByMonth = salaryByYear.get(month);
            if (salaryByMonth == null)
                System.out.println("Salary not found for this month: " + month);
            else {
                System.out.println("-".repeat(51));
                System.out.printf("|%8sEarnings%8s|%7sDeductions%7s|\n", "", "", "", "");
                System.out.println("-".repeat(51));
                System.out.printf("|%3sBasic = %10s%3s|%4sPF = %10s%5s|\n", "", String.format("%.2f", salaryByMonth.getBasic()), "", "", String.format("%.2f", salaryByMonth.getPF()), "");
                System.out.printf("|%4sHRA = %10s%4s|%4sTDS = %10s%4s|\n", "", String.format("%.2f", salaryByMonth.getHRA()), "", "", String.format("%.2f", salaryByMonth.getTDS()), "");
                System.out.println("-".repeat(51));
                System.out.printf("|%12sNet Salary = %11s%13s|\n", "", String.format("%.2f", salaryByMonth.getSalary()), "");
                System.out.println("-".repeat(51));
            }
        }
    }

    public void totalMonthlySalaryExpense() {
        Map<String, Map<Month, Float>> monthlyExpense = new TreeMap<>(Comparator.reverseOrder());

        for (Employee emp : employees) {
            for (String year : emp.getSalaryMap().keySet()) {
                Map<Month, Float> monthSalarySum = monthlyExpense.getOrDefault(year, new TreeMap<>());
                for (Map.Entry<Month, Salary> salaryByMonth : emp.getSalaryMap().get(year).entrySet()) {
                    Month month = salaryByMonth.getKey();
                    float salary = salaryByMonth.getValue().getSalary();
                    monthSalarySum.put(month, monthSalarySum.getOrDefault(month, 0f) + salary);
                }
                monthlyExpense.put(year, monthSalarySum);
            }
        }

        //printing result
        monthlyExpense.forEach((year, monthMap) -> {
            System.out.println("Year: " + year);
            monthMap.forEach((month, totalSalary) -> {
                System.out.printf("  %s: %.2f\n", month, totalSalary);
            });
        });
    }

    public void averageSalaryOfEveryEmployeeYearly() {
        employees.forEach(emp -> {
            Map<String, Double> yearlyAverageSalaries = emp.getSalaryMap().entrySet().stream()
                    .collect(Collectors.toMap(
                            (yearlyEntry) -> yearlyEntry.getKey(),
                            yearlyEntry -> yearlyEntry.getValue().values().stream()
                                    .collect(Collectors.averagingDouble(Salary::getSalary))
                    ));
            // Printing the result
            System.out.println(emp.toString() + ":");
            yearlyAverageSalaries.forEach((year, avgSalary) -> {
                System.out.printf("  Year: %s, average salary: %.2f\n", year, avgSalary);
            });
        });
    }

    public void averageSalaryCountryWise() {
        employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getAddress().getCountry(),
                        Collectors.averagingDouble(Employee::getBaseSalary)
                )).forEach((country, avgSalary) -> {
                    System.out.printf("Country: %s, Average Salary: %.2f\n", country, avgSalary);
                });
    }

    public void employeesWithMaxSalary() {
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getBaseSalary(), e1.getBaseSalary()))
                .forEach(emp -> {
                    System.out.printf("employee = %s , salary = %.2f", emp, emp.getBaseSalary());
                });
    }

    public void topFiveEmployeesWithMaxSalary() {
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getBaseSalary(), e1.getBaseSalary()))
                .limit(5)
                .forEach(emp -> {
                    System.out.printf("employee = %s , salary = %.2f", emp, emp.getBaseSalary());
                });
    }

    public void employeesByStatus() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus))
                .forEach((status, employee) -> {
                    System.out.println("Status: " + status);
                    employee.forEach(emp -> System.out.println("  " + emp));
                });
    }

    public void employeesCountByStatus() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()))
                .forEach((status, count) -> {
                    System.out.println("Status: " + status + ", count: " + count);
                });
    }

    public void listOfEmployeesOnLeaveToday() {
        List<Employee> employeesOnLeave = employees.stream()
                .filter(EmployeeOperations::isOnLeaveToday)
                .collect(Collectors.toList());

        System.out.println(employeesOnLeave);
    }

    public void listOfEmployeesOnLeave(String date) {
        List<Employee> employeesOnLeave = employees.stream()
                .filter(emp -> EmployeeOperations.isOnLeave(emp, date))
                .collect(Collectors.toList());

        System.out.println(employeesOnLeave);
    }

    public void paySalary() {
        Scanner input = new Scanner(System.in);

        System.out.print("pay to: \n1. single employee \n2. all employees \n: ");
        int payOption = input.nextInt();
        if (payOption!=1 && payOption!=2)  {
            System.out.println("wrong pay option input!");
            return;
        }
        Employee emp = null;
        if (payOption==1) {
            System.out.print("Enter employee id: ");
            int id = input.nextInt();
            emp = findEmployeeByID(id);
            if (emp==null) {
                System.out.println("Employee not found");
                return;
            }
        }

        System.out.print("which month: \n1. current month \n2. specific month \n: ");
        int monthOption = input.nextInt();
        switch (monthOption) {
            case 1: {
                if (payOption==1) {
                    EmployeeOperations.paySalary(emp);
                } else {
                    employees.forEach(EmployeeOperations::paySalary);
                }
                break;
            } case 2: {
                System.out.print("Enter month number: ");
                int month = input.nextInt();
                if (month<1 || month>12) {
                    System.out.println("invalid month!");
                    break;
                }
                System.out.print("Enter year number: ");
                int year = input.nextInt();

                System.out.print("Salary option: \n1. base salary \n2. specify salary \n3. Bonus \n: ");
                int salaryOption = input.nextInt();

                if (salaryOption==2) {
                    System.out.print("Enter basic salary amount: ");
                    float basic = input.nextFloat();

                    if (payOption==1) {
                        EmployeeOperations.paySalary(emp, String.valueOf(year), String.valueOf(month), basic);
                    } else {
                        employees.forEach(employee -> {
                            EmployeeOperations.paySalary(employee, String.valueOf(year), String.valueOf(month), basic);
                        });
                    }
                } else if (salaryOption==3) {
                    System.out.print("Enter bonus(%): ");
                    float bonus = input.nextFloat();

                    if (payOption==1) {
                        float basic = emp.getBaseSalary() + (emp.getBaseSalary()*bonus/100);
                        EmployeeOperations.paySalary(emp, String.valueOf(year), String.valueOf(month), basic);
                    } else {
                        employees.forEach(employee -> {
                            float basic = employee.getBaseSalary() + (employee.getBaseSalary()*bonus/100);
                            EmployeeOperations.paySalary(employee, String.valueOf(year), String.valueOf(month), basic);
                        });
                    }
                } else {
                    if (payOption==1) {
                        EmployeeOperations.paySalary(emp, String.valueOf(year), String.valueOf(month));
                    } else {
                        employees.forEach(employee -> {
                            EmployeeOperations.paySalary(employee, String.valueOf(year), String.valueOf(month));
                        });
                    }
                }
                break;
            } default:
                System.out.println("Wrong month option Input!");
        }
        System.out.println("salary paid successfully!");
    }

    //working on it
    public void hireEmployee() {
        String firstName, lastName, dob, dateOfJoining, city, state, country;
        EmployeeStatus status;
        float baseSalary;
        int houseNumber, pincode;
        Scanner input = new Scanner(System.in);

        Employee emp;
        try {
            System.out.println("Enter employee details--");
            System.out.print("Enter first name: ");
            firstName = input.nextLine();
            System.out.print("Enter last name: ");
            lastName = input.nextLine();

            System.out.print("Enter DOB (dd/mm/yyyy): ");
            dob = input.next();
            LocalDate.parse(dob, Employee.dateFormat);              //to check date validity
            input.nextLine();

            System.out.print("Enter date of joining (dd/mm/yyyy): ");
            dateOfJoining = input.next();
            LocalDate.parse(dateOfJoining, Employee.dateFormat);              //to check date validity
            input.nextLine();

            System.out.print("Enter house number: ");
            houseNumber = input.nextInt();
            input.nextLine();

            System.out.print("Enter city: ");
            city = input.nextLine();

            System.out.print("Enter state: ");
            state = input.nextLine();

            System.out.print("Enter country: ");
            country = input.nextLine();

            System.out.print("Enter pincode: ");
            pincode = input.nextInt();
            input.nextLine();

            System.out.print("Enter base salary: ");
            baseSalary = input.nextFloat();
            input.nextLine();

            System.out.println("Enter status: ");
            int i=1;
            for (EmployeeStatus s: EmployeeStatus.values()) {
                System.out.println(i++ + ". " + s);
            }
            System.out.print(": ");
            int statusNumber = input.nextInt();
            input.nextLine();
            if (statusNumber<0 || statusNumber>=EmployeeStatus.values().length) {
                System.out.println("wrong input!");
                return;
            }
            status = EmployeeStatus.values()[statusNumber-1];

            Employee newEmployee = new Employee(employees.size()+1, firstName, lastName, dob, new Address(houseNumber, city, state, country, pincode), status, baseSalary, dateOfJoining);
            employees.add(newEmployee);
            System.out.println("Employee hired successfully!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date!");
        }
    }
}
