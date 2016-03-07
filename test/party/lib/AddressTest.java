package party.lib;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void testAddCountry() throws Exception {
        Label lbl = new Label("Mr Soni Singh");
        Address address = new Address("Bangalore","Karnataka","India");
        Label label = address.addCountry(lbl);
        Label expected = new Label("Mr Soni Singh,India");
        assertEquals(expected,label);
    }

    @Test
    public void testIsFrom() throws Exception {
        String country = "India";
        String anotherCountry = "China";
        Address add = new Address("Bangalore","Karnataka","India");
        assertTrue(add.isFrom(country));
        assertFalse(add.isFrom(anotherCountry));
    }
}