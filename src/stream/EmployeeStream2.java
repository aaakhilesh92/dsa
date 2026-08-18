package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStream2 {

    public static void main(String[] args) {
        List<Employee2> employeeList = Employee2.getEmployeeList();
        maleFemaleEmployeesCount(employeeList);
        sortEmployeeBasedOnSalary(employeeList);
    }

    // How many male and female employees are there in the organization?
    public static void maleFemaleEmployeesCount(List<Employee2> employeeList) {
        System.out.println("########## maleFemaleEmployeesCount #########");
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee2::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
    }

    public static void sortEmployeeBasedOnSalary(List<Employee2> employeeList) {
        System.out.println("########## sortEmployeeBasedOnSalary #########");
        List<Employee2> sortedEmp = employeeList.stream().sorted(Comparator.comparingDouble(Employee2::getSalary)).collect(Collectors.toList());
        sortedEmp.forEach(System.out::println);
    }

}
