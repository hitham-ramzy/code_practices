package designPatterns.structure;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class FlyWeightPatternTest {

    @Test
    public void flyWeightPatternTest(){
        PersonFactory personFactory = new PersonFactory();
        Person person1 =  personFactory.createPerson("Person1");
        Person person2 =  personFactory.createPerson("Person2");
        Person person3 =  personFactory.createPerson("Person1");

        assertEquals(person1, person3);
        assertNotSame(person1, person2);

    }
}
