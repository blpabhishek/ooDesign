package party.record;

import party.lib.*;

public class RecordParser {
    public static Person createRecord(String value) {
        String [] records =value.split(",");
        if(records.length!=7)
            throw new RuntimeException("Every record should be in [firstName,lastName,gender,age,city,state,country] form");
        try {
            Integer.parseInt(records[3]);
        }catch (NumberFormatException nfe){
            throw new NumberFormatException("Age should be an Integer");
        }
        return createPerson(records);
    }
    private static Person createPerson(String[] str){
        Name name = new Name(str[0], str[1]);
        Gender gender = (str[2].contains("F"))?Gender.FEMALE:Gender.MALE;
        Integer age = Integer.parseInt(str[3]);
        Address address = new Address(str[4],str[5],str[6]);
        Person person = new Person(name,gender,age,address);
        return  person;
    }
}

