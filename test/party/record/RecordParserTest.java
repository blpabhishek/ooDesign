package party.record;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import party.lib.Address;
import party.lib.Gender;
import party.lib.Name;
import party.lib.Person;

import static org.junit.Assert.*;

public class RecordParserTest {
    Name name;
    Integer age;
    Gender gender;
    Address address;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        name = new Name("Gavin","Hyatt");
        age = 36;
        gender = Gender.MALE;
        address =new Address("Crooks ton","Illinois","Romania");
    }

    @Test
    public void testCreateRecordReturnsThePersonRecord() throws Exception {
        String record = "Gavin,Hyatt,Male,36,Crooks ton,Illinois,Romania";
        Person person = RecordParser.createRecord(record);
        Person expected = new Person(name,gender,age,address);
        assertEquals(expected,person);
    }

    @Test
    public void testCreateRecordReturnsThePersonRecordForFemale() throws Exception {
        String record = "Gavin,Hyatt,Female,36,Crooks ton,Illinois,Romania";
        Person person = RecordParser.createRecord(record);
        gender = Gender.FEMALE;
        Person expected = new Person(name,gender,age,address);
        assertEquals(expected,person);
    }

    @Test
    public void testCreateRecordReturnsErrorIfRecordIsNotValid() throws Exception {
        String record = "Gavin,Hyatt,Male,36,Crooks ton,Illinois,Romania,Somalia";
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Every record should be in [firstName,lastName,gender,age,city,state,country] form");
        Person person = RecordParser.createRecord(record);
    }

    @Test
    public void testCreateRecordReturnsErrorIfAgeIsNotValid() throws Exception {
        String record = "Gavin,Hyatt,Male,Thirteen,Crooks ton,Illinois,Romania";
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("Age should be an Integer");
        Person person = RecordParser.createRecord(record);
    }
}