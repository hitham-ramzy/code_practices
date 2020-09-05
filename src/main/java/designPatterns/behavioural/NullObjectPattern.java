package designPatterns.behavioural;

import java.util.Arrays;
import java.util.List;

public class NullObjectPattern {
    private static List<String> customers = Arrays.asList("Hitham", "Ramzy", "Anwer");

    public static AbstractCustomer getCustomer(String customerName) {
        for (String s : customers) {
            if (s.equals(customerName)) {
                return new Customer(s);
            }
        }
        return new NullCustomer();
    }

}


abstract class AbstractCustomer {
    String name;

    abstract public String getName();

    abstract public boolean isNull();
}

class Customer extends AbstractCustomer {

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}

class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "NULL OBJECT";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}


