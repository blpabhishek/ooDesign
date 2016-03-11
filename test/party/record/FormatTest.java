package party.record;

import org.junit.Before;
import org.junit.Test;
import party.lib.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FormatTest {
    private Format formatLast;
    private Name name;
    private Address address;
    private Person person;
    private Format formatFirst;

    @Before
    public void setUp() throws Exception {
        formatFirst = new Format("f");
        formatLast = new Format("l");
        name = new Name("Ramu", "Kaka");
        address = new Address("Kormangla", "Karnataka", "India");
        person = new Person(name, Gender.MALE, 21, address);
    }
    @Test
    public void testApplyShouldGiveFormat() throws Exception {
        Label lbl = new Label("Mr Ramu Kaka");
        assertEquals(lbl,formatFirst.apply(person));
    }

    @Test
    public void testApplyShouldGiveAnotherFormat() throws Exception {
        Label lbl = new Label("Mr Kaka,Ramu");
        assertEquals(lbl,formatLast.apply(person));
    }



    @Test
    public void testShouldBeAbleToCompareWithItself() throws Exception {
        assertEquals(formatFirst,formatFirst);
        Format f = new Format("f");
        assertEquals(formatFirst,f);

    }

    @Test
    public void testShouldBeAbleToCompareWithItselfWhenItIsNotEqual() throws Exception {
        Format l = new Format("l");
        assertNotEquals(formatFirst,l);
    }

    @Test
    public void testShouldBeAbleToGiveStringRepresentation() throws Exception {
        assertEquals(formatFirst.toString(),"f");
        assertEquals(formatLast.toString(),"l");
    }

}