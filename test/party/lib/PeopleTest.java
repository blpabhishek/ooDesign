package party.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleTest {

    private People people;
    private Person person;

    @Before
    public void setUp() throws Exception {
        people = new People();
        Name name = new Name("Julius","Barrows");
        Address address = new Address("Veda haven","Vermont","Macedonia");
        person = new Person(name, Gender.FEMALE,18, address);
    }

    @Test
    public void testShouldBeAbleToAddNewPerson() throws Exception {
        assertTrue(people.addPerson(person));
    }

    @Test
    public void testPrintLabels() throws Exception {

    }
}