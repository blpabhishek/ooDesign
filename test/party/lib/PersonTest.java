package party.lib;

import party.lib.Person;
import party.lib.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        Name name = new Name("Julius","Barrows");
        Address address = new Address("Veda haven","Vermont","Macedonia");
        person = new Person(name, Gender.FEMALE,18,address);
    }

    @Test
    public void testShouldBeAbleToGetAFirstLastNameWithCountry() throws Exception {
        Label name = person.getFirstLastNameLabel();
        assertEquals("Ms Julius Barrows,Macedonia",name.toString());
    }

    @Test
    public void testShouldBeAbleToGetLastFirstNameWithCountry() throws Exception {
        Label name = person.getLastFirstNameLabel();
        assertEquals("Ms Barrows,Julius,Macedonia",name.toString());
    }
}
