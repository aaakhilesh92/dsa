package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeStream {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployeeList();
        highestSalaryEmployee(employeeList);
        // sortEmployeeBasedOnSalary(employeeList);
        // sortEmployeeBasedOnSalaryAndName(employeeList);
        getMaxSalaryEmployeeByDepartment(employeeList);
    }

    public static void highestSalaryEmployee(List<Employee> list) {
        System.out.println("********** Highest Salary Employee **********");
        Optional<Employee> emp = list.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println(emp);
    }

    public static void sortEmployeeBasedOnSalary(List<Employee> list) {
        System.out.println("**********Sort Employee based on Salary **********");
        List<Employee> sortedEmp = list.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
        sortedEmp.forEach(System.out::println);
        System.out.println();
        // String str = list.stream().sorted(Comparator.comparingInt(Employee::getSalary)).map(Employee::toString).collect(Collectors.joining("##"));
        // System.out.println(str);
    }

    public static void sortEmployeeBasedOnSalaryAndName(List<Employee> list) {
        System.out.println("**********Sort Employee based on Salary and Name **********");
        List<Employee> sortedEmp = list.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getName)))
                .collect(Collectors.toList());
        sortedEmp.forEach(System.out::println);
        System.out.println();
        // String str =
        // list.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName)).map(Employee::toString).collect(Collectors.joining("##"));
        // System.out.println(str);
    }

    public static void getMaxSalaryEmployeeByDepartment(List<Employee> list) {
        System.out.println("**********getMaxSalaryEmployeeByDepartment **********");

        Map<String, Employee> topEmployees = list.stream()
                .collect(Collectors.groupingBy(e -> e.getDept(), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(e -> e.getSalary())), Optional::get)));
        System.out.println(topEmployees);
        Map<String, Employee> topEmployees2 = list.stream().collect(Collectors.toMap(e -> e.getDept(), e -> e, BinaryOperator.maxBy(Comparator.comparingInt(e -> e.getSalary()))));
        System.out.println(topEmployees2);
        Map<String, Optional<Employee>> topEmployees3 = list.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(e -> e.getSalary())))));
        System.out.println(topEmployees3);
    }

}
