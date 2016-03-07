package party.record;

import org.junit.Before;
import org.junit.Test;
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
}