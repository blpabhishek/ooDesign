package party.record;

import org.junit.Before;
import org.junit.Test;
import party.lib.Address;
import party.lib.Gender;
import party.lib.Name;
import party.lib.Person;

import static org.junit.Assert.*;

public class FilterTest {

    private Filter countryFilter;
    private Name name;
    private Address address;
    private Person person;
    private Filter ageFilter;

    @Before
    public void setUp() throws Exception {
        countryFilter = new Filter("c", "India");
        ageFilter = new Filter("a", "20");
        name = new Name("Ramu", "Kaka");
        address = new Address("Kormangla", "Karnataka", "India");
        person = new Person(name, Gender.MALE, 21, address);
    }
    @Test
    public void testApplyShouldGiveTrueIfCriteriaIsMatched() throws Exception {
        assertTrue(countryFilter.apply(person));
        assertTrue(ageFilter.apply(person));
    }

    @Test
    public void testApplyShouldGiveFalseWhenCriteriaIsNotMatched() throws Exception {
        address = new Address("Mani","Bolgano","Italy");
        person = new Person(name, Gender.MALE, 18, address);
        assertFalse(countryFilter.apply(person));
        assertFalse(ageFilter.apply(person));
    }

    @Test
    public void testShouldBeAbleToCompareWithItself() throws Exception {
        assertEquals(ageFilter,ageFilter);
        Filter filter = new Filter("a", "20");
        assertEquals(ageFilter,filter);
    }

    @Test
    public void testShouldBeAbleToCompareWithItselfWhenItIsNotEqual() throws Exception {
        Filter filter = new Filter("a", "21");
        assertNotEquals(ageFilter,filter);
    }

    @Test
    public void testShouldBeAbleToGiveStringRepresentation() throws Exception {
        assertEquals(ageFilter.toString(),"a");
        assertEquals(countryFilter.toString(),"c");
    }

    @Test
    public void testShouldBeGiveTrueWhenNoCriteriaIsMatched() throws Exception {
        Filter filter = new Filter("p", "prank");
        assertTrue(filter.apply(person));
    }
}