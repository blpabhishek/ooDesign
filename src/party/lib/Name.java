package party.lib;

public class Name {
    private String separator=" ";
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    protected String firstLastName(){
        separator =" ";
        return firstName+separator+lastName;
    }
    protected String lastFirstName(){
        separator =",";
        return lastName+separator+firstName;
    }

    @Override
    public String toString() {
        return firstName + separator + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        if (!separator.equals(name.separator)) return false;
        if (!firstName.equals(name.firstName)) return false;
        if (!lastName.equals(name.lastName)) return false;
        return true;
    }

}