package problems.project2.utils;

import problems.project2.model.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReaderWriter {
    // customDelimiter
    private String delim;
    private String filename;

    public CSVReaderWriter(String filename) {
        this.delim = "\" , \"";
        this.filename = filename;
    }

    public CSVReaderWriter(String filename, String delim) {
        this.delim = delim;
        this.filename = filename;
    }

    public String getDelim() {
        return delim;
    }

//    public void setDelim(String delim) {
//        this.delim = delim;
//    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String fileName) {
        this.filename = fileName;
    }

    public TreeSet<Employee> readEmployeesFromCSV() {
        Set<Employee> employees = new TreeSet<>();

        try (
                BufferedReader bfr = new BufferedReader(new FileReader(filename))
        ) {
            String headerString = bfr.readLine();
            if (headerString == null) {
                return new TreeSet<>();
            }
            String[] headers = headerString.substring(1, headerString.length()-1).split(delim);

            employees = bfr.lines()
                    .filter(line -> line.length()>2)
                    .map(line -> {
                        String[] data = line.substring(1, line.length()-1).split(delim);
                        Map<String, String> dataMap = new LinkedHashMap<>();

                        for (int i=0; i < headers.length; i++) {
                            dataMap.put(headers[i], data[i]);
                        }

                        Employee emp = new Employee(
                                Integer.parseInt(dataMap.get("id").trim()),
                                dataMap.get("firstName"),
                                dataMap.get("lastName"),
                                dataMap.get("dob"),
                                createAddressByString(dataMap.get("address")),
                                EmployeeStatus.valueOf(dataMap.get("status")),
                                Float.parseFloat(dataMap.get("baseSalary")),
                                dataMap.get("dateOfJoining")
                        );

                        emp.setLeaveBalance(Float.parseFloat(dataMap.get("leaveBalance")));
                        emp.setLeaveHistory(leaveHistoryListByString(dataMap.get("leaveHistory")));
                        emp.setSalaryMap(mapSalaryObjectFromString(dataMap.get("salaryMap"), emp));

                        return emp;
                    }).collect(Collectors.toSet());

        } catch (IOException ioe) {
            System.out.println("failed to read csv file!");
            System.out.println("Error message: " + ioe.getMessage());
        }

        return new TreeSet<>(employees);
    }

    public void writeEmployeesToCSV(Set<Employee> employees) {

        String[] header = {"id", "firstName", "lastName", "dob", "address", "status", "baseSalary", "dateOfJoining", "salaryMap", "leaveBalance", "leaveHistory"};

        try {
            File file = new File(filename);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("file created successfully!");
                } else {
                    System.out.println("file already exists!");
                }
            }

            try (
                    BufferedWriter bfw = new BufferedWriter(new FileWriter(filename))
            ) {
                bfw.write("\"" + String.join(delim, header) + "\"");
                bfw.newLine();

                for (Employee emp: employees) {
                    String line = "\"" + emp.getId() + delim + emp.getFirstName() + delim + emp.getLastName() + delim + emp.getDOB() + delim + emp.getAddress().fullAddress() + delim + emp.getStatus() + delim + emp.getBaseSalary() + delim + emp.getDateOfJoining() + delim + mapSalaryStringFromObject(emp.getSalaryMap()) + delim + emp.getLeaveBalance() + delim + emp.getLeaveHistory().toString() + "\"";

                    bfw.write(line);
                    bfw.newLine();
                };

                System.out.println("Data saved successfully!");
            } catch (IOException ioe) {
                System.out.println("failed to write csv file!");
                System.out.println("Error message: " + ioe.getMessage());
            }
        } catch (IOException ioe) {
            System.out.println("Failed to create file!");
            System.out.println("Error message: " + ioe.getMessage());
        }
    }

    private static Address createAddressByString(String str) {
        String[] addressArray = str.split(", ");
        return new Address(Integer.parseInt(addressArray[0]), addressArray[1], addressArray[2], addressArray[3], Integer.parseInt(addressArray[4]));
    }

    private static List<String> leaveHistoryListByString(String str) {
        String leaveHistoryString = str.substring(1, str.length()-1);
        if (leaveHistoryString.length()==0 || str.equals("[]"))
            return new ArrayList<>();
        else
            return Arrays.asList(leaveHistoryString.split(", "));
    }

    private static String mapSalaryStringFromObject(TreeMap<String, TreeMap<Month, Salary>> salaryMap) {
        return salaryMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue().entrySet().stream()
                        .map(innerEntry -> innerEntry.getKey().name() + ": " + innerEntry.getValue().getBasic() + " | " + innerEntry.getValue().getPenalty())
                        .collect(Collectors.joining(", ", "{", "}"))
                )
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static TreeMap<String, TreeMap<Month, Salary>> mapSalaryObjectFromString(String str, Employee emp) {
        TreeMap<String, TreeMap<Month, Salary>> result = new TreeMap<>(Comparator.reverseOrder());

        if (str.equals("[]"))
            return result;

        String[] yearWiseArray = str.substring(1, str.length()-1).split("}, ");
        for (String yearWiseString: yearWiseArray) {
            String[] yearWiseStringSplit = yearWiseString.substring(0, yearWiseString.length()-1).split(": \\{");
            String year = yearWiseStringSplit[0];

            String[] monthSalarySplit = yearWiseStringSplit[1].split(", ");
            for (String monthSalary: monthSalarySplit) {
                String month = monthSalary.split(": ")[0];
                String salaryData = monthSalary.split(": ")[1];

                float salaryBasic = Float.parseFloat(salaryData.split(" \\| ")[0]);
                float penalty = Float.parseFloat(salaryData.split(" \\| ")[1]);
                Salary salary = new Salary(salaryBasic, emp, year, Month.valueOf(month).getMonthNumber(), penalty);

                result.putIfAbsent(year, new TreeMap<>());
                result.get(year).put(Month.valueOf(month), salary);
            }
        }

        return result;
    }
}