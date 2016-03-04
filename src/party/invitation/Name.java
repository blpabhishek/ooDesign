package party.invitation;

public class Name {
    private String separator;
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this(firstName,lastName,' ');
    }
    public Name(String firstName, String lastName,char separator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.separator = new String(separator+"");
    }
    public String firstLastName(){
        return firstName+separator+lastName;
    }
    public String lastFirstName(){
        return lastName+separator+firstName;
    }

}
