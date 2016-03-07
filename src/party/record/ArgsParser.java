package party.record;

public class ArgsParser {
	private final String[] args;	
	public ArgsParser(String[] args){
		this.args = args;
	}
	private boolean isOption(String arg){
		return arg.indexOf("-")==0;
	}
	public String getOptions(){
		String option = new String();
		for (String arg: args)
			if(isOption(arg))
				option+=arg.replace("-","");
		return option;
	}
	public String[] getFiles(){
		String files="";
		for (String arg: args) 
			if(!isOption(arg))
				files+=arg+"\n";
		return files.split("\n");
	}
}