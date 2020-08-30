package designPatterns.structure;

import org.junit.Test;

public class ComposePatternTest {

    @Test
    public void composePatternTest(){
        Employee hithamEmployee = new Employee("Hitham", "IT", 12);
        hithamEmployee.addEmployee(new Employee("Ahmed", "IT", 12));
        hithamEmployee.addEmployee(new Employee("Mohamed", "IT", 12));

        Employee naderEmployee = new Employee("Nader", "IT", 12);
        naderEmployee.addEmployee(hithamEmployee);

        naderEmployee.getSubordinates().forEach(System.out::println);

    }
}
