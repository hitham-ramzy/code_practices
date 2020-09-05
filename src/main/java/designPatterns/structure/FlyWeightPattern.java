package designPatterns.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Fly weight pattern.
 * <p>
 * Used for reduce the number of object created and to decrease the memory foot print
 */
public class FlyWeightPattern {
}

class Person {
    String name;
    int age;
    String mobile;
}

class PersonFactory {

    private Map<String, Person> map = new HashMap<>();

    Person createPerson(String name) {
        Person person = map.get(name);

        if (person == null) {
            person = new Person();
            person.name = name;
            map.put(name, person);
            System.out.println("new person created and added to the map");
        }
        return person;
    }

}
