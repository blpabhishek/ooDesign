package party.lib;

import party.lib.Person;
import party.lib.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person;
    private Name name;
    private Address address;

    @Before
    public void setUp() throws Exception {
        name = new Name("Julius","Barrows");
        address = new Address("Veda haven","Vermont","Macedonia");
        person = new Person(name, Gender.FEMALE,18, address);
    }

    @Test
    public void testShouldBeAbleToGetAFirstLastNameWithCountry() throws Exception {
        Label name = person.getFirstLastNameLabel();
        name = person.addCountry(name);
        assertEquals("Ms Julius Barrows,Macedonia",name.toString());
    }

    @Test
    public void testShouldBeAbleToAddAgeInLabel() throws Exception {
        Label name = person.getFirstLastNameLabel();
        name = person.addAge(name);
        assertEquals("Ms Julius Barrows,18",name.toString());
    }

    @Test
    public void testShouldBeAbleToCheckPersonIsFromCountryOrNot() throws Exception {
        assertTrue(person.isFrom("Macedonia"));
        assertFalse(person.isFrom("China"));
    }

    @Test
    public void testIsGreater() throws Exception {
        assertTrue(person.isGreater(17));
        assertFalse(person.isGreater(19));
    }

    @Test
    public void testShouldBeAbleToGetLastFirstNameWithCountry() throws Exception {
        Label name = person.getLastFirstNameLabel();
        name = person.addCountry(name);
        assertEquals("Ms Barrows,Julius,Macedonia",name.toString());
    }

    @Test
    public void testShouldBeAbleToCompareWithPerson() throws Exception {
        assertEquals(person,person);
        Person anotherPerson = new Person(name,Gender.FEMALE,26,address);
        assertNotEquals(person,anotherPerson);
    }


    @Test
    public void testShouldBeAbleToGetStringRepresentation() throws Exception {
        assertEquals(person.toString(),"Ms Julius Barrows,Veda haven,Vermont,Macedonia,18");
    }


}
