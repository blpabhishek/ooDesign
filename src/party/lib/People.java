package party.lib;

import party.record.Option;

import java.util.*;

public class People {
    private Collection<Person> collection;
    public People() {
        this.collection = new HashSet<>();
    }
    public boolean addPerson(Person p){
        return collection.add(p);
    }

    public People argumentFilter(List on){
        People people = new People();
        for (Object o : on) {
            people = filter((Option) o);
        }
        return people;
    }

    public People filter(Option on){
        People filteredCollection = new People();
        for(Person p:collection){
            if(on.apply(p))
                filteredCollection.addPerson(p);
         }
        return filteredCollection;
    }

    public Label printLabelsLastFirst(String allOptions) {
        Label output = new Label("");
        for (Person person : collection) {
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
    public Label printLabelsFirstLast(String allOptions) {
        Label output = new Label("");
        for (Person person : collection) {
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

    public Label printLabels(List options) {
        String allOptions = options.toString();
        if(allOptions.contains("f"))
            return printLabelsFirstLast(allOptions);
        return printLabelsLastFirst(allOptions);
    }
}
