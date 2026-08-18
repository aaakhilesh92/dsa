package stream;

import java.util.ArrayList;
import java.util.List;

public class Employee2 {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    public Employee2(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public static List<Employee2> getEmployeeList() {
        List<Employee2> employeeList = new ArrayList<Employee2>();
        employeeList.add(new Employee2(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee2(122, "Paul Niksui", 25, "Male", "Sales", 2015, 13500.0));
        employeeList.add(new Employee2(133, "Martin Theron", 29, "Male", "Infra", 2012, 18000.0));
        employeeList.add(new Employee2(144, "Murali Gowda", 28, "Male", "Software", 2014, 32500.0));
        employeeList.add(new Employee2(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee2(166, "Iqbal Hussain", 43, "Male", "IT", 2016, 10500.0));
        employeeList.add(new Employee2(177, "Manu Sharma", 35, "Male", "Finance", 2010, 27000.0));
        employeeList.add(new Employee2(188, "Wang Liu", 31, "Male", "Software", 2015, 34500.0));
        employeeList.add(new Employee2(199, "Amelia Zoe", 24, "Female", "Sales", 2016, 11500.0));
        employeeList.add(new Employee2(200, "Jaden Dough", 38, "Male", "IT", 2015, 11000.0));
        employeeList.add(new Employee2(211, "Jasna Kaur", 27, "Female", "Infra", 2014, 15700.0));
        employeeList.add(new Employee2(222, "Nitin Joshi", 25, "Male", "Software", 2016, 28200.0));
        employeeList.add(new Employee2(233, "Jyothi Reddy", 27, "Female", "Finance", 2013, 21300.0));
        employeeList.add(new Employee2(244, "Nicolus Den", 24, "Male", "Sales", 2017, 10700.0));
        employeeList.add(new Employee2(255, "Ali Baig", 23, "Male", "Infra", 2018, 12700.0));
        employeeList.add(new Employee2(266, "Sanvi Pandey", 26, "Female", "Software", 2015, 28900.0));
        employeeList.add(new Employee2(277, "Anuj Chettiar", 31, "Male", "Software", 2012, 35700.0));
        return employeeList;
    }

    @Override
    public String toString() {
        return String.format("Employee2 [id=%-3d, name=%-13s, age=%-2d, gender=%-6s, department=%-8s, yearOfJoining=%-4d, salary=%-6.1f]", id, name, age, gender, department,
                yearOfJoining, salary);
    }
}
