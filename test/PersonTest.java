import party.invitation.Person;
import org.junit.Before;
import org.junit.Test;
import party.invitation.*;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        Name name = new Name("Julius","Barrows");
        Address address = new Address("Veda haven", "Vermont", "Macedonia");
        person = new Person(name, Gender.FEMALE,18,address);
    }

    @Test
    public void testShouldBeAbleToGetAFirstLastName() throws Exception {
        Label name = person.getFirstLastName();
        Label lbl = new Label("Ms Julius Barrows");
        assertEquals(lbl.toString(),name.toString());
    }

    @Test
    public void testShouldBeAbleToGetLastFirstName() throws Exception {
        Label name = person.getLastFirstName();
        assertEquals("Ms Barrows Julius",name.toString());
    }

    @Test
    public void testShouldBeAbleToGetCountryNameWithLabel() throws Exception {
        Label name = person.getLastFirstName();
        name = person.addCountryInLabel(name);
        assertEquals("Ms Barrows Julius,Macedonia",name.toString());
    }
}
