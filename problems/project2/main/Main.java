package problems.project2.main;

import problems.project2.model.*;
import problems.project2.service.*;
import problems.project2.utils.CSVReaderWriter;

import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String filename = "./problems/project2/resources/employeesData.csv";

        CSVReaderWriter csvReaderWriter = new CSVReaderWriter(filename);
        TreeSet<Employee> employees = csvReaderWriter.readEmployeesFromCSV();

        EmployeeListOperations employeeListOperations = new EmployeeListOperations(employees);
        boolean wantToContinue = true;
        while (wantToContinue) {
            try {
                System.out.print("Login as: \n1. Admin \t2. Employee \t3. Exit \n:");
                int loginType = input.nextInt();
                switch (loginType) {
                    case 1: {
                        input.nextLine();
                        System.out.print("Enter admin name: ");
                        String name = input.nextLine();
                        System.out.print("Enter admin password: ");
                        String password = input.nextLine();

                        if ("xyz".equals(name) && "xyz".equals(password))
                            asAdmin(employeeListOperations);
                        else
                            System.out.println("Wrong id or password!");
                        break;
                    }
                    case 2: {
                        input.nextLine();
                        System.out.print("Enter employee name: ");
                        String name = input.nextLine();
                        System.out.print("Enter employee id: ");
                        int id = input.nextInt();

                        Employee currentEmployee = employees.stream().
                                filter(emp -> emp.getFullName().equals(name) && emp.getId() == id)
                                .findFirst()
                                .orElse(null);

                        if (currentEmployee != null)
                            asEmployee(employeeListOperations, currentEmployee);
                        else
                            System.out.println("employee not found");
                        break;
                    }
                    case 3: {
                        System.out.println("Thanks for visiting us!");
                        wantToContinue = false;
                        break;
                    }
                    default:
                        System.out.println("Wrong Input!");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid Input!");
                input.nextLine();
            } catch (DateTimeParseException dte) {
                System.out.println("Invalid Date!");
                input.nextLine();
            }
        }
        csvReaderWriter.writeEmployeesToCSV(employees);
    }

    public static void asAdmin(EmployeeListOperations employeeListOperations) throws InputMismatchException {
        int wantToContinue=1;
        while (wantToContinue==1) {
            System.out.print("Your Options are: \n1. print All Employees \n2. print All employee live in same city and country \n3. print monthly salary expense \n4. print all employees by address \n5. print employee details \n6. print Salary Slip \n7. average salary of every employee yearly \n8. average salary country wise \n9. five employees by maximum salary \n10. employees by maximum salary \n11. find all employees by status \n12. find all employees count by status \n13. employees on leave today \n14. employees on leave (specific date) \n15. pay salary \n16. hire employee \n17. logout \n:");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    employeeListOperations.printAllEmployees();
                    break;
                case 2:
                    employeeListOperations.employeeLiveInSameCityAndCountry();
                    break;
                case 3:
                    employeeListOperations.totalMonthlySalaryExpense();
                    break;
                case 4:
                    employeeListOperations.printByAddress();
                    break;
                case 5: {
                    System.out.print("Enter employee id: ");
                    int id = input.nextInt();
                    Employee emp = employeeListOperations.findEmployeeByID(id);
                    if (emp==null) {
                        System.out.println("Employee not found");
                        break;
                    }
                    EmployeeOperations.printDetails(emp);
                    break;
                }
                case 6: {
                    System.out.print("Enter employee id: ");
                    int id = input.nextInt();
                    Employee emp = employeeListOperations.findEmployeeByID(id);
                    if (emp==null) {
                        System.out.println("Employee not found");
                        break;
                    }
                    System.out.print("Enter year number: ");
                    int year = input.nextInt();
                    System.out.print("Enter month number: ");
                    int month = input.nextInt();

                    employeeListOperations.printPaySlipByMonth(emp, String.valueOf(year), String.valueOf(month));
                    break;
                }
                case 7:
                    employeeListOperations.averageSalaryOfEveryEmployeeYearly();
                    break;
                case 8:
                    employeeListOperations.averageSalaryCountryWise();
                    break;
                case 9:
                    employeeListOperations.topFiveEmployeesWithMaxSalary();
                    break;
                case 10:
                    employeeListOperations.employeesWithMaxSalary();
                    break;
                case 11:
                    employeeListOperations.employeesByStatus();
                    break;
                case 12:
                    employeeListOperations.employeesCountByStatus();
                    break;
                case 13:
                    employeeListOperations.listOfEmployeesOnLeaveToday();
                    break;
                case 14: {
                    System.out.print("Enter the date(dd/mm/yyyy): ");
                    String date = input.next();
                    employeeListOperations.listOfEmployeesOnLeave(date);
                    break;
                }
                case 15:
                    employeeListOperations.paySalary();
                    break;
                case 16:
                    employeeListOperations.hireEmployee();
                    break;
                case 17: {
                    System.out.println("logging out...");
                    return;
                }
                default:
                    System.out.println("Wrong input!");
            }
            input.nextLine();
            System.out.print("Do You want to continue: \n1. Yes\n2. No \n:");
            wantToContinue = input.nextInt();
        }
        System.out.println("logging out...");
    }

    public static void asEmployee(EmployeeListOperations employeeListOperations, Employee emp) throws InputMismatchException {
        int wantToContinue=1;
        while (wantToContinue==1) {
            System.out.print("Your Options are: \n1. print details \n2. print Salary Slip \n3. print leave history \n4. check leave balance \n5. apply leaves \n6. apply leaves (in range) \n7. logout \n:");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    EmployeeOperations.printDetails(emp);
                    break;
                case 2: {
                    System.out.print("Enter year number: ");
                    int year = input.nextInt();
                    System.out.print("Enter month number: ");
                    int month = input.nextInt();

                    employeeListOperations.printPaySlipByMonth(emp, String.valueOf(year), String.valueOf(month));
                    break;
                }
                case 3:
                    System.out.println(emp.getLeaveHistory());
                    break;
                case 4:
                    System.out.println(emp.getLeaveBalance());
                    break;
                case 5:
                    System.out.print("How many leaves do you want: ");
                    int count = input.nextInt();
                    List<String> dateList = new ArrayList<>();
                    for (int i=1; i<=count; i++) {
                        System.out.printf("Enter date%d: ", i);
                        String date = input.next();
                        dateList.add(date);
                    }
                    EmployeeOperations.applyLeave(emp, dateList);
                    break;
                case 6: {
                    System.out.print("Enter start date: ");
                    String from = input.next();
                    System.out.print("Enter end date: ");
                    String to = input.next();
                    EmployeeOperations.applyLeave(emp, from, to);
                    break;
                }
                case 7: {
                    System.out.println("logging out...");
                    return;
                }
                default:
                    System.out.println("Wrong input!");
            }

            System.out.print("Do You want to continue: \n1. Yes\n2. No \n:");
            wantToContinue = input.nextInt();
        }
        System.out.println("logging out...");
    }
}
