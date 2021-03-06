package designPatterns.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Composite pattern.
 * <p>
 * Used where you need to treat a group of objects in similar was as a single object
 * <p>
 * Perfect in a tree hierarchy
 */
public class CompositePattern {

}

class Employee {

    private String name;
    private String department;
    private int salary;
    private List<Employee> subordinates = new ArrayList<>();

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    void deleteEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", " +
                subordinates.stream().map(Employee::toString).collect(Collectors.joining(" ")) +
                '}';
    }
}


