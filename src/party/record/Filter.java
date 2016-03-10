package party.record;

import party.lib.Person;

public class Filter {
    private String option;
    private String parameters;

    public Filter(String option, String parameters) {
        this.option = option;
        this.parameters = parameters;
    }

    public boolean apply(Person person){
        if(option.equals("c"))
            return person.isFrom(parameters);
        if(option.equals("a"))
            return person.isGreater(Integer.parseInt(parameters));
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        if (!option.equals(filter.option)) return false;
        if (parameters != null ? !parameters.equals(filter.parameters) : filter.parameters != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = option.hashCode();
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }
}
