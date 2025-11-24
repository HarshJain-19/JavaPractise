package problems.problem1;

import java.util.*;

class CompareEmployeeByAddress implements Comparator<Employee> {
    private String by= "all";

    CompareEmployeeByAddress() {}
    CompareEmployeeByAddress(String by) {
        this.by = by;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1==null) {
            if (emp2==null)
                return 0;
            else
                return -1;
        }
        if ("country".equalsIgnoreCase(by))
            return emp1.getAddress().getCountry().compareTo(emp2.getAddress().getCountry());
        else if ("state".equalsIgnoreCase(by))
            return emp1.getAddress().getState().compareTo(emp2.getAddress().getState());
        else if ("city".equalsIgnoreCase(by))
            return emp1.getAddress().getCity().compareTo(emp2.getAddress().getCity());
        else if ("pincode".equalsIgnoreCase(by))
            return emp1.getAddress().getPincode() - emp2.getAddress().getPincode();
        else if ("housenumber".equalsIgnoreCase(by))
            return emp1.getAddress().getHouseNumber() - emp2.getAddress().getHouseNumber();
        else
            return (emp1.getAddress().getCountry()+emp1.getAddress().getState()+emp1.getAddress().getCity()+emp1.getAddress().getHouseNumber()).compareTo(emp2.getAddress().getCountry()+emp2.getAddress().getState()+emp2.getAddress().getCity()+emp1.getAddress().getHouseNumber());
    }
}

public final class OperationsOnEmployee {
    private OperationsOnEmployee() {}

    // map(year, map(month, salary))
    public static Map<String, Map<Month, Salary>> createSalaryMap(Salary ...salaries) {
        TreeMap<String, Map<Month, Salary>> salaryMap = new TreeMap<>();
        for (Salary salary : salaries) {
            if (salaryMap.containsKey(salary.getYear())) {
                salaryMap.get(salary.getYear()).put(Month.getMonthByNumber(salary.getMonth()), new Salary(salary));
            } else {
                Map<Month, Salary> temp = new HashMap<>();
                temp.put(Month.getMonthByNumber(salary.getMonth()), new Salary(salary));
                salaryMap.put(salary.getYear(), temp);
            }
        }
        return salaryMap;
    }

    // list(employee)
    public static List<Employee> removeDuplicateEmployeesFromList(List<Employee> empList) {
        return new ArrayList<>(new HashSet<>(empList));
    }

    // map(city+country, list(employee))
    public static Map<String, List<Employee>> employeeLiveInSameCityAndCountry(List<Employee> empList) {
        HashMap<String, List<Employee>> sameCityAndCountryEmployeesMap = new HashMap<>();

        for(Employee emp : empList) {
            String location = emp.getAddress().getCity()+", "+emp.getAddress().getCountry();
            sameCityAndCountryEmployeesMap.putIfAbsent(location, new ArrayList<>());
            sameCityAndCountryEmployeesMap.get(location).add(emp);
        }

        Iterator<Map.Entry<String, List<Employee>>> iterator = sameCityAndCountryEmployeesMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<Employee>> entry = iterator.next();
            if (entry.getValue().size() < 2)
                iterator.remove();
        }

        sameCityAndCountryEmployeesMap.forEach((location, employees) -> {
            System.out.println(employees+" lives in "+ employees.get(0).getAddress().getCity() + ", " + employees.get(0).getAddress().getCountry());
        });

        return sameCityAndCountryEmployeesMap;
    }

    public static void sortByAddress(List<Employee> empList) {
        empList.sort(new CompareEmployeeByAddress());
    }

    public static void sortByAddress(List<Employee> empList, String by) {
        empList.sort(new CompareEmployeeByAddress(by));
    }

    public static void printEmployeeByNameAndAddress(List<Employee> empList) {
        empList.forEach(emp -> {
            System.out.println(emp.getFullName() + " - " + emp.getAddress());
        });
    }

    public static void printPaySlipByMonth(Employee emp, String year, Month month) {
        if (emp==null)
            throw new NullPointerException("Employee cannot be null");
        Map<Month, Salary> salaryByYear = emp.getSalaryMap().get(year);
        if (salaryByYear==null)
            System.out.println("Salary not found for this year: "+ year);
        else {
            Salary salaryByMonth = salaryByYear.get(month);
            if (salaryByMonth==null)
                System.out.println("Salary not found for this month: "+ month);
            else {
                System.out.println("-".repeat(51));
                System.out.printf("|%8sEarnings%8s|%7sDeductions%7s|\n", "", "", "", "");
                System.out.println("-".repeat(51));
                System.out.printf("|%3sBasic = %10s%3s|%4sPF = %10s%5s|\n", "", String.format("%.2f",salaryByMonth.getBasic()), "", "", String.format("%.2f",salaryByMonth.getPF()),"");
                System.out.printf("|%4sHRA = %10s%4s|%4sTDS = %10s%4s|\n", "", String.format("%.2f",salaryByMonth.getHRA()), "", "", String.format("%.2f",salaryByMonth.getTDS()), "");
                System.out.println("-".repeat(51));
                System.out.printf("|%12sNet Salary = %11s%13s|\n", "", String.format("%.2f", salaryByMonth.getSalary()), "");
                System.out.println("-".repeat(51));
            }
        }
    }

    // map(year, map(month, sumOfSalary))
    public static Map<String, Map<Month, Float>> getTotalMonthlySalaryExpense(List<Employee> empList) {
        Map<String, Map<Month, Float>> monthlyExpense = new TreeMap<>();

        for (Employee emp: empList) {
            for (String year: emp.getSalaryMap().keySet()) {
                Map<Month, Float> monthSalarySum = new HashMap<>();
                monthlyExpense.putIfAbsent(year, monthSalarySum);
                for (Map.Entry<Month, Salary> salaryByMonth: emp.getSalaryMap().get(year).entrySet()) {
                    monthSalarySum.put(salaryByMonth.getKey(), monthSalarySum.getOrDefault(salaryByMonth.getKey(), 0f) + salaryByMonth.getValue().getSalary());
                }
            }
        }
        System.out.println(monthlyExpense);

        return monthlyExpense;
    }

    // map(employee, map(year, average))
    public static Map<String, Map<String, Float>> getAverageSalaryOfEveryEmployeeYearly(List<Employee> empList) {
        Map<String, Map<String, Float>> averageSalaryOfEveryEmployeeYearly = new HashMap<>();

        for(Employee emp: empList) {
            averageSalaryOfEveryEmployeeYearly.putIfAbsent(emp.toString(), new TreeMap<>());
            for(Map.Entry<String, Map<Month, Salary>> salaryYearEntry: emp.getSalaryMap().entrySet()) {
                float salSum=0;
                int count=0;
                for(Salary salary: salaryYearEntry.getValue().values()) {
                    salSum += salary.getSalary();
                    count++;
                }
                averageSalaryOfEveryEmployeeYearly.get(emp.toString()).put(salaryYearEntry.getKey(), (float) salSum/count);
            }
        }

        averageSalaryOfEveryEmployeeYearly.entrySet().forEach(System.out::println);

        return averageSalaryOfEveryEmployeeYearly;
    }

    // map(country, map(year, map(month, average))
    public static Map<String, Map<String, Map<Month, Float>>> getAverageSalaryCountryWise(List<Employee> empList) {
        Map<String, Map<String, Map<Month, List<Salary>>>> helper = new HashMap<>();

        for (Employee emp: empList) {
            helper.putIfAbsent(emp.getAddress().getCountry(), new TreeMap<>());

            for (Map.Entry<String, Map<Month, Salary>> yearlySalary: emp.getSalaryMap().entrySet()) {
                helper.get(emp.getAddress().getCountry()).putIfAbsent(yearlySalary.getKey(), new HashMap<>());

                for (Map.Entry<Month, Salary> monthlySalary: yearlySalary.getValue().entrySet()) {
                    helper.get(emp.getAddress().getCountry()).get(yearlySalary.getKey()).putIfAbsent(monthlySalary.getKey(), new ArrayList<Salary>());
                    helper.get(emp.getAddress().getCountry()).get(yearlySalary.getKey()).get(monthlySalary.getKey()).add(monthlySalary.getValue());
                }
            }
        }

        Map<String, Map<String, Map<Month, Float>>> averageSalaryCountryWise = new HashMap<>();

        for (Map.Entry<String, Map<String, Map<Month, List<Salary>>>> e1: helper.entrySet()) {
            Map<String, Map<Month, Float>> m1 = new HashMap<>();
            averageSalaryCountryWise.put(e1.getKey(), m1);
            for (Map.Entry<String, Map<Month, List<Salary>>> e2: e1.getValue().entrySet()) {
                Map<Month, Float> m2 = new HashMap<>();
                m1.put(e2.getKey(), m2);
                for (Map.Entry<Month, List<Salary>> e3: e2.getValue().entrySet()) {
                    float avg = 0f;
                    for (Salary s: e3.getValue()) {
                        avg+= s.getSalary();
                    }
                    avg /= e3.getValue().size();
                    m2.put(e3.getKey(), avg);
                }
            }
        }

        averageSalaryCountryWise.entrySet().forEach(System.out::println);

        return averageSalaryCountryWise;
    }

    // map(employee, salary)
    public static Map<Employee, Salary> get5EmployeeWithMaxSalary(List<Employee> empList, Month month, String year) {
        // getting all employee with there salary
        Map<Employee, Salary> employeeWithSalary = new HashMap<>();

        for (Employee emp: empList) {
            Salary sal = emp.getSalaryMap().getOrDefault(year, new HashMap<>()).get(month);
            if (sal!=null)
                employeeWithSalary.put(emp, sal);
        }

        // sorting employeeWithMaxSalary by salary (reverse sorting map by value)
        List<Map.Entry<Employee, Salary>> employeeSalaryEntryList = new LinkedList<>(employeeWithSalary.entrySet());
        employeeSalaryEntryList.sort(new Comparator<Map.Entry<Employee, Salary>>() {
            @Override
            public int compare(Map.Entry<Employee, Salary> o1, Map.Entry<Employee, Salary> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //taking 5 max
        Map<Employee, Salary> fiveEmployeeWithMaxSalary = new LinkedHashMap<>();
        Iterator<Map.Entry<Employee, Salary>> employeeSalaryEntryIterator = employeeSalaryEntryList.iterator();
        for (int i=0; i<5 && employeeSalaryEntryIterator.hasNext(); i++) {
            Map.Entry<Employee, Salary> singleEntry = employeeSalaryEntryIterator.next();
            fiveEmployeeWithMaxSalary.put(singleEntry.getKey(), singleEntry.getValue());
        }

        System.out.println(fiveEmployeeWithMaxSalary);

        return fiveEmployeeWithMaxSalary;
    }

    // map(status, list(employee))
    public static Map<EmployeeStatus, List<Employee>> getEmployeesByStatus(List<Employee> empList) {
        Map<EmployeeStatus, List<Employee>> employeesByStatus = new HashMap<>();
        for (EmployeeStatus status: EmployeeStatus.values()) {
            employeesByStatus.put(status, new ArrayList<>());
        }
        for (Employee emp: empList) {
            employeesByStatus.get(emp.getStatus()).add(emp);
        }

        return employeesByStatus;
    }

    // map(status, count)
    public static Map<EmployeeStatus, Integer> getEmployeeCountByStatus(List<Employee> empList) {
        Map<EmployeeStatus, Integer> employeeCountByStatus = new EnumMap<>(EmployeeStatus.class);

        for (Map.Entry<EmployeeStatus, List<Employee>> employeeStatusMapEntry: getEmployeesByStatus(empList).entrySet()) {
            employeeCountByStatus.put(employeeStatusMapEntry.getKey(), employeeStatusMapEntry.getValue().size());
        }

        return employeeCountByStatus;
    }

    // list(employee)
    public static List<Employee> listOfEmployeeOnLeaveToday(List<Employee> empList) {
        List<Employee> employeesOnLeaveToday = new ArrayList<>();
        for (Employee emp: empList) {
            if (emp.isOnLeaveToday())
                employeesOnLeaveToday.add(emp);
        }
        return employeesOnLeaveToday;
    }

}
