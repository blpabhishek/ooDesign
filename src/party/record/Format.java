package party.record;

import party.lib.Label;
import party.lib.Person;

public class Format {
    private String options;

    public Format(String options) {
        this.options = options;
    }

    public Label apply(Person person){
        if(options.equals("l"))
            return person.getLastFirstNameLabel();
        return person.getFirstLastNameLabel();
    }

    @Override
    public String toString() {
        return options.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Format format = (Format) o;

        if (!options.equals(format.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return options.hashCode();
    }
}
