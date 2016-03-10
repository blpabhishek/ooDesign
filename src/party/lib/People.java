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

    public Label printLabels(Format format, List<Filter> filters)  {
        Label label = new Label("");
        People people = this;
        if(filters.size()!=0)
            people = applyFilter(filters);
        for (Person person : people.collection) {
            Label lbl = format.apply(person);
            for (Filter filter : filters) {
                if(filter.toString().equals("c"))
                    person.addCountry(lbl);
                if(filter.toString().equals("a"))
                    person.addAge(lbl);
            }
            label.add(lbl);
            label.addNewLine();
        }
        return  label;
    }
}
