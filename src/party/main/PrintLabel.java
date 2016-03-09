package party.main;

import party.lib.People;
import party.record.ArgsParser;
import party.record.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PrintLabel {
    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser(args);
        List files = parser.getFiles();
        List options = parser.getOptions();
        People people = new People();
        for (Object file : files) {
            try {
                people = Reader.readFile((String) file);
            } catch (FileNotFoundException fne) {
                System.err.println("party.main.PrintLabel :" + fne.getMessage());
            } catch (IOException ioe) {
                System.err.println("party.main.PrintLabel :" + ioe.getMessage());
            }
            people = people.argumentFilter(options);
            System.out.println(people.printLabels(options));
        }
    }
}
