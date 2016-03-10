package party.lib;

import party.record.Filter;
import party.record.Format;

import java.util.HashSet;
import java.util.List;

public class People {
    private HashSet<Person> collection;
    public People() {
        this.collection = new HashSet<>();
    }
    public boolean addPerson(Person p){
        return collection.add(p);
    }

    private People applyFilter(List<Filter> on){
        HashSet <Person> hashSet = new HashSet<>();
        hashSet = (HashSet<Person>) collection.clone();
        People people = new People();
        for (Filter f : on) {
            people = filter(f,hashSet);
            hashSet = people.collection;
        }
        return people;
    }

    private People filter(Filter on,HashSet<Person> collection){
        People filteredCollection = new People();
        for(Person p:collection){
            if(on.apply(p)) {
                filteredCollection.addPerson(p);
            }
         }
        return filteredCollection;
    }

    public Label printLabels(Format options, List<Filter> filters) {
        String format = options.toString();
        if(filters.size()!=0){
            People people = applyFilter(filters);
            if(format.contains("f"))
                return printLabelsFirstLast(format,people);
            return printLabelsLastFirst(format,people);
        }
        if(format.contains("f"))
            return printLabelsFirstLast(format);
        return printLabelsLastFirst(format);
    }

    private Label printLabelsLastFirst(String format) {
        Label output = new Label("");
        for (Person person : collection) {
            Label lbl = person.getLastFirstNameLabel();
            output.add(lbl);
            output.addNewLine();
        }
        return output;
    }

    private Label printLabelsFirstLast(String format) {
        Label output = new Label("");
        for (Person person :collection) {
            Label lbl = person.getLastFirstNameLabel();
            output.add(lbl);
            output.addNewLine();
        }
        return output;
    }

    private Label printLabelsLastFirst(String allOptions,People people) {
        Label output = new Label("");
        for (Person person : people.collection) {
            Label lbl = person.getLastFirstNameLabel();
            if(allOptions.contains("c"))
                person.addCountry(lbl);
            if(allOptions.contains("a"))
                person.addAge(lbl);
            output.add(lbl);
            output.addNewLine();
        }
        return output;
    }
    private Label printLabelsFirstLast(String allOptions, People people) {
        Label output = new Label("");
        for (Person person : people.collection) {
            Label lbl = person.getFirstLastNameLabel();
            if(allOptions.contains("c"))
                person.addCountry(lbl);
            if(allOptions.contains("a"))
                person.addAge(lbl);
            output.add(lbl);
            output.addNewLine();
        }
        return output;
    }

}
