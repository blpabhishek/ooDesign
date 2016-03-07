package party.lib;

import java.util.ArrayList;
import java.util.Collection;

public class Persons {
    private Collection<Person> collection;
    public Persons() {
        this.collection = new ArrayList<>();
    }
    public boolean addPerson(Person p){
        return collection.add(p);
    }
    public Persons filter(String on){
        Persons filteredCollection = new Persons();
        for(Person p:collection){
           //TODO if(on.contains("f")
            filteredCollection.addPerson(p);
        }
        return filteredCollection;
    }

    public Label printLabels(String  options) {
        Label output = new Label("");
        for (Person person : collection) {
            output.add(person.printLabel(options));
            output.addNewLine();
        }
        return output;
    }
}
