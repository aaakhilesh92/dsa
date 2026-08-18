package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private int empId;
    private int salary;
    private String name;
    private String dept;

    public int getEmpId() {
        return empId;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public Employee(int empId, String name, int salary, String dept) {
        super();
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return String.format(" Employee [empId=%-1d, salary=%-4d, name=%-8s, dept=%-2s ]", empId, salary, name, dept);
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Akhilesh", 3000, "SW"));
        employeeList.add(new Employee(4, "Mayank", 2400, "QA"));
        employeeList.add(new Employee(5, "Ravi", 2600, "QA"));
        employeeList.add(new Employee(6, "Amit", 1500, "SW"));
        employeeList.add(new Employee(7, "Tanya", 1200, "IT"));
        employeeList.add(new Employee(8, "Somesh", 1600, "QA"));
        employeeList.add(new Employee(2, "Priti", 1200, "SW"));
        employeeList.add(new Employee(3, "Kanika", 2600, "IT"));
        return employeeList;
    }

    public static void main(String[] args) {
        List<Employee> list = Employee.getEmployeeList();
        Comparator<Employee> cmp = (e1, e2) -> e1.getSalary() - e2.getSalary();
        // List<String> list = new ArrayList<String>();

        list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).forEach(System.out::println);
        // list.stream().sorted(cmp.reversed()).forEach(System.out::println);
    }
}
