package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ind");
        list.add("pa");
        list.add("aug");
        list.add("usa");
        list.add("ban");
        AtomicInteger ai = new AtomicInteger(1);
        Map<String, Integer> map = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toMap(Function.identity(), x -> ai.getAndIncrement()));
        System.out.println(map);

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("A", "IT", 1999, 20));
        employees.add(new Employee("B", "CX", 1999, 11));
        employees.add(new Employee("C", "MARK", 1999, 10));
        employees.add(new Employee("D", "IT", 1999, 15));
        employees.add(new Employee("E", "MARK", 1999, 12));
        employees.add(new Employee("F", "CX", 1999, 4));

        Map<String, Employee> map2 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(e -> e.salary)), Optional::get)));

        int[] arr = {1, 2, 3, 4, 5, 6, 1, 3, 5, 2, 3, 6};
        Map<Integer, Long> map3 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        System.out.println(map3);

    }
}
class Employee {
    String name;
    String dept;
    int age;
    int salary;
    Employee(String name, String dept, int age, int salary) {
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", dept=" + dept + ", age=" + age + "]";
    }
}
