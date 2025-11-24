package association;

class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class University {
    private String name;
    private Department department; // Aggregation: University has a Department

    public University(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void showInfo() {
        System.out.println(name + " has the " + department.getName() + " department.");
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Department dept = new Department("Computer Science");
        University uni = new University("XYZ University", dept);

        uni.showInfo();
    }
}

