package party.invitation;

public class Person{
    private Name name;
    private Address address;
    private Gender gender;
    private Integer age;
    public Person(Name name,Gender gender,Integer age,Address address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }
    public Label getFirstLastName(){
        return new Label(gender+name.firstLastName());
    }
    public Label getLastFirstName(){
        return new Label(gender+name.lastFirstName());
    }
    public Label addCountryInLabel(Label label){
        char separator = ',';
        Label lbl = new Label(separator+address.getCountry());
        label.add(lbl);
        return label;
    }
}