import party.lib.Person;
import party.lib.Persons;
import party.record.ArgsParser;
import party.record.RecordParser;

import java.io.*;

public class PrintLabel {
    public static void readFile(String fileName, String options) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String strLine;
        Persons persons = new Persons();
        while ((strLine = br.readLine()) != null) {
            Person record = RecordParser.createRecord(strLine);
            persons.addPerson(record);
        }
        br.close();
        System.out.println(persons.filter(options).printLabels(options));
    }

    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser(args);
        String[] files = parser.getFiles();
        String options = parser.getOptions();
        for (String file : files) {
            try {
                readFile(file, options);
            } catch (FileNotFoundException fne) {
                System.err.println("PrintLabel :" + fne.getMessage());
            } catch (IOException ioe) {
                System.err.println("PrintLabel :" + ioe.getMessage());
            }
        }
    }
}
