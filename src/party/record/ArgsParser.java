package party.record;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArgsParser {
	private final String[] args;	
	public ArgsParser(String[] args){
		this.args = args;
	}
	private boolean isOption(String arg){
		return arg.indexOf("-")==0;
	}
    private static String replace(String str){
        return str.replace("-","");
    }
    private boolean isFileOption(String arg) {
        return arg.equals("-p");
    }
    private Option createOption(String option,String next){
        if(option.equals("f") || option.equals("l"))
            return new Format(option);
        else
            return new Filter(option,next);
    }
	public List getOptions(){
        List<Option> options = new LinkedList<>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (isOption(arg) && !isFileOption(arg)) {
                arg = ArgsParser.replace(arg);
                Option option = createOption(arg,args[i+1]);
                options.add(option);
            }
        }
		return options;
	}
	public List getFiles() {
        List<String> files = new LinkedList<>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (isOption(arg) && isFileOption(arg)) {
                arg = ArgsParser.replace(arg);
                files.add(args[i+1]);
            }
        }
        return files;
    }
}