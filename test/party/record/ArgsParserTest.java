package party.record;

import org.junit.Assert;
import org.junit.Test;

public class ArgsParserTest {
	@Test
	public void getFiles_returns_all_the_files(){
		String [] args ={"-f","file"};
		ArgsParser p = new ArgsParser(args);
		String[] expected = {"file"};
		Assert.assertArrayEquals(expected,p.getFiles());
	}
	@Test
	public void getOptions_returns_all_the_options(){
		String [] args ={"-f","file"};
		ArgsParser p = new ArgsParser(args);
		String expected = new String("f");
		Assert.assertEquals(expected,p.getOptions());
	}
	@Test
	public void getOptions_returns_all_the_options_given_together(){
		String [] args ={"-fl","file"};
		ArgsParser p = new ArgsParser(args);
		String expected = new String("fl");
		Assert.assertEquals(expected,p.getOptions());
	}
	@Test
	public void getOptions_returns_all_the_options_given_mixed(){
		String [] args ={"-fl","-c","file"};
		ArgsParser p = new ArgsParser(args);
		String expected = new String("flc");
		Assert.assertEquals(expected,p.getOptions());
	}
}