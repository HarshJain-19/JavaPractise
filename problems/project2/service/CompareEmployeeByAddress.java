package problems.project2.service;

import problems.project2.model.*;

import java.util.Comparator;

public class CompareEmployeeByAddress implements Comparator<Employee> {
    private String by = "all";

    CompareEmployeeByAddress() {}

    CompareEmployeeByAddress(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1 == null) {
            if (emp2 == null)
                return 0;
            else
                return -1;
        }
        switch (by.toLowerCase()) {
            case "country":
                return emp1.getAddress().getCountry().compareTo(emp2.getAddress().getCountry());
            case "state":
                return emp1.getAddress().getState().compareTo(emp2.getAddress().getState());
            case "city":
                return emp1.getAddress().getCity().compareTo(emp2.getAddress().getCity());
            case "pincode":
                return emp1.getAddress().getPincode() - emp2.getAddress().getPincode();
            case "housenumber":
                return emp1.getAddress().getHouseNumber() - emp2.getAddress().getHouseNumber();
            default:
                return (emp1.getAddress().getCountry() + emp1.getAddress().getState() + emp1.getAddress().getCity() + emp1.getAddress().getHouseNumber()).compareTo(emp2.getAddress().getCountry() + emp2.getAddress().getState() + emp2.getAddress().getCity() + emp2.getAddress().getHouseNumber());
        }
    }
}
