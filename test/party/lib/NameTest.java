package party.lib;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    Name name;
    @Before
    public void setUp() throws Exception {
        name = new Name("Julius","Barrows");
    }

    @Test
    public void testCanGetNameInFirstLastNameFormat() throws Exception {
        assertEquals("Julius Barrows",name.firstLastName());
    }

    @Test
    public void testCanGetNameInLastFirstNameFormat() throws Exception {
        assertEquals("Barrows,Julius",name.lastFirstName());
    }

    @Test
    public void testNameShouldBeEqualsToItself() throws Exception {
        assertEquals(name,name);
        Name second = new Name("Julius","Barrows");
        assertEquals(second,name);
    }
}
