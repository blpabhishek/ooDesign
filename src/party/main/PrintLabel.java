package party.main;

import party.lib.People;
import party.record.ArgsParser;
import party.record.Filter;
import party.record.Format;
import party.record.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PrintLabel {
    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser(args);
        List<String> files = parser.getFiles();
        List<Filter> filters = parser.getFilters();
        Format format = parser.getFormat();
        People people = new People();
        for (Object file : files) {
            try {
                people = Reader.readFile((String) file);
            } catch (FileNotFoundException fne) {
                System.err.println("PrintLabel :" + fne.getMessage());
            } catch (IOException ioe) {
                System.err.println("PrintLabel :" + ioe.getMessage());
            }
            System.out.println(people.printLabels(format,filters));
        }
    }
}
