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
        Label lbl = new Label(gender+name.firstLastName());
        return address.addCountry(lbl);
    }
    public Label getLastFirstNameLabel(){
        Label lbl =  new Label(gender+name.lastFirstName());
        return address.addCountry(lbl);
    }

    public Label printLabel(String options) {
        if(options.contains("f"))
            return getFirstLastNameLabel();
        return getLastFirstNameLabel();
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
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", address=" + address +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}