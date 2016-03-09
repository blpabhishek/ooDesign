package party.record;

import party.lib.Person;

public class Format extends Filter {
    private String options;

    public Format(String options) {
        super(options,null);
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Format format = (Format) o;

        if (!options.equals(format.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }
}
