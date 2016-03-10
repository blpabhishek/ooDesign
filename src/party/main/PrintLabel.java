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
    public static void main(String[] args) throws IOException {
        ArgsParser parser = new ArgsParser(args);
        List<String> files = parser.getFiles();
        List<Filter> filters = parser.getFilters();
        Format format = parser.getFormat();
        People people = new People();
        for (Object file : files) {
            people = Reader.readFile((String) file);
            System.out.println(people.printLabels(format,filters));
        }
    }
}
