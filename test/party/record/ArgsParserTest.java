package party.record;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ArgsParserTest {
	@Test
	public void testGetFilesReturnsAllTheFiles(){
		String [] args ={"-p","file"};
		ArgsParser p = new ArgsParser(args);
		ArrayList expected = new ArrayList<>();
		expected.add("file");
		assertEquals(expected,p.getFiles());
	}

	@Test
	public void testGetOptionsReturnsAllTheOptions(){
		String [] args ={"-f","-p","file"};
		ArgsParser p = new ArgsParser(args);
		assertEquals(new Format("f"),p.getFormat());
	}
	@Test
	public void testGetOptionsReturnsAllTheOptionsGivenTogether(){
		String [] args ={"-l","-a","20","-p","file"};
		ArgsParser p = new ArgsParser(args);
		List<Filter> expected = new LinkedList<>();
		expected.add(new Filter("a","20"));
		assertEquals(expected,p.getFilters());
		assertEquals(new Format("l"),p.getFormat());
	}
	@Test
	public void testGetOptionsReturnsAllTheOptionsGivenMixed(){
		String [] args ={"-c","country","-p","file"};
		ArgsParser p = new ArgsParser(args);
		List<Filter> expected = new LinkedList<>();
		expected.add(new Filter("c","country"));
		List<String> expectedFiles = new LinkedList<>();
		expectedFiles.add("file");
		assertEquals(expected,p.getFilters());
		assertEquals(expectedFiles,p.getFiles());
		assertEquals(new Format("f"),p.getFormat());
	}
}