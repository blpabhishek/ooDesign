package party.lib;

import org.junit.Before;
import org.junit.Test;
import party.record.Filter;
import party.record.Format;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeopleTest {

    private People people;
    private Person person;
    private Person anotherPerson;

    @Before
    public void setUp() throws Exception {
        people = new People();
        Name name = new Name("Julius","Barrows");
        Address address = new Address("Veda haven","Vermont","Macedonia");
        person = new Person(name, Gender.FEMALE,18, address);
        name = new Name("Jhon","Tariya");
        anotherPerson = new Person(name,Gender.MALE,25,address);
    }

    @Test
    public void testShouldBeAbleToAddNewPerson() throws Exception {
        assertTrue(people.addPerson(person));
    }

    @Test
    public void testPrintLabelsShouldGiveLabelAccordingToFormat() throws Exception {
        people.addPerson(person);
        Label l = people.printLabels(new Format("l"), new LinkedList<Filter>());
        Label label = new Label("Ms Barrows,Julius\n");
        assertEquals(label,l);
    }

    @Test
    public void testPrintLabelsShouldGiveLabelAccordingToFormatAndFilter() throws Exception {
        people.addPerson(person);
        people.addPerson(anotherPerson);
        LinkedList<Filter> filters = new LinkedList<>();
        filters.add(new Filter("a", "20"));
        Label l = people.printLabels(new Format("l"), filters);
        Label label = new Label("Mr Tariya,Jhon,25\n");
        assertEquals(label,l);
    }
    @Test
    public void testPrintLabelsShouldGiveLabelAccordingToFormatAndAllFilters() throws Exception {
        people.addPerson(person);
        people.addPerson(anotherPerson);
        LinkedList<Filter> filters = new LinkedList<>();
        filters.add(new Filter("c", "Macedonia"));
        filters.add(new Filter("a", "20"));
        Label l = people.printLabels(new Format("l"), filters);
        Label label = new Label("Mr Tariya,Jhon,Macedonia,25\n");
        assertEquals(l,label);
    }
}