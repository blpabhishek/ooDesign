package party.record;

import party.lib.Person;
import party.lib.People;

import java.io.*;

public class Reader {
    public static People readFile(String fileName) throws IOException {
        FileReader inputStream = new FileReader(fileName);
        BufferedReader br = new BufferedReader(inputStream);
        String strLine;
        People people = new People();
        while ((strLine = br.readLine()) != null) {
            Person record = RecordParser.createRecord(strLine);
            people.addPerson(record);
        }
        br.close();
        return people;
    }
}
