package party.record;

import org.junit.Assert;
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
		List<Option> expected = new LinkedList<>();
		expected.add(new Format("f"));
		assertEquals(expected,p.getOptions());
	}
	@Test
	public void testGetOptionsReturnsAllTheOptionsGivenTogether(){
		String [] args ={"-f","-a","20","-p","file"};
		ArgsParser p = new ArgsParser(args);
		List<Option> expected = new LinkedList<>();
		expected.add(new Format("f"));
		expected.add(new Filter("a","20"));
		assertEquals(expected,p.getOptions());
	}
	@Test
	public void testGetOptionsReturnsAllTheOptionsGivenMixed(){
		String [] args ={"-f","-c","country","-p","file"};
		ArgsParser p = new ArgsParser(args);
		List<Option> expected = new LinkedList<>();
		expected.add(new Format("f"));
		expected.add(new Filter("c","country"));
		List<String> expectedFiles = new LinkedList<>();
		expectedFiles.add("file");
		assertEquals(expected,p.getOptions());
		assertEquals(expectedFiles,p.getFiles());
	}
}