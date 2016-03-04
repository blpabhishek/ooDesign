import party.invitation.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    Name nameWithDelimiter;
    Name name;
    @Before
    public void setUp() throws Exception {
        name = new Name("Julius", "Barrows");
        nameWithDelimiter =  new Name("Julius", "Barrows",',');
    }

    @Test
    public void testCanGetNameInFirstLastNameFormat() throws Exception {
        assertEquals("Julius Barrows",name.firstLastName());
        assertEquals("Julius,Barrows",nameWithDelimiter.firstLastName());
    }

    @Test
    public void testCanGetNameInLastFirstNameFormat() throws Exception {
        assertEquals("Barrows Julius",name.lastFirstName());
        assertEquals("Barrows,Julius",nameWithDelimiter.lastFirstName());
    }
}
