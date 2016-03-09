package party.lib;

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
    public Label getFirstLastNameLabel(){
       return new Label(gender+name.firstLastName());
    }
    public Label getLastFirstNameLabel(){
        return new Label(gender+name.lastFirstName());
    }
    public Label addCountry(Label lbl){
        return address.addCountry(lbl);
    }
    public Label addAge(Label lbl) {
        lbl.add(new Label(","+age ));
        return lbl;
    }

    public boolean isFrom(String parameters) {
        return address.isFrom(parameters);
    }

    public boolean isGreater(Integer age) {
        return (this.age > age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (!name.equals(person.name)) return false;
        if (!address.equals(person.address)) return false;
        if (gender != person.gender) return false;
        if (!age.equals(person.age)) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s%s,%s,%d",gender,name,address,age);
    }


}