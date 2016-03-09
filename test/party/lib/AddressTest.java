package party.lib;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    @Test
    public void testAddCountryShouldAddCountryInTheLabel() throws Exception {
        Label lbl = new Label("Mr Amar Singh");
        Address address = new Address("Bangalore","Karnataka","India");
        Label label = address.addCountry(lbl);
        Label expected = new Label("Mr Amar Singh,India");
        assertEquals(expected,label);
    }

    @Test
    public void testIsFromShouldGiveTrueOrFalseWhenPersonIsFromOrNotOfThatCountry() throws Exception {
        String country = "India";
        String anotherCountry = "China";
        Address add = new Address("Bangalore","Karnataka","India");
        assertTrue(add.isFrom(country));
        assertFalse(add.isFrom(anotherCountry));
    }

    @Test
    public void testEqualsShouldBeAbleToCompareTwoAddress() throws Exception {
        Address address = new Address("Bangalore","Karnataka","India");
        Address alternateAddress = new Address("Bangalore","Karnataka","India");
        assertEquals(alternateAddress,address);
    }

    @Test
    public void testToStringShouldBeAbleToGiveStringRepresentation() throws Exception {
        Address address = new Address("Bangalore","Karnataka","India");
        assertEquals("Bangalore,Karnataka,India",address.toString());
    }

}