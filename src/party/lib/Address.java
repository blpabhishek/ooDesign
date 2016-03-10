package party.lib;

public class Address {
    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    protected Label addCountry(Label label){
        char separator = ',';
        Label lbl = new Label(separator+country);
        label.add(lbl);
        return label;
    }
    protected boolean isFrom(String country){
       return this.country.equals(country);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",city,state,country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        if (!country.equals(address.country)) return false;
        return true;
    }
}
