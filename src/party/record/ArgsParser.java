package party.record;

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

    private boolean isFormat(String option){
        return (option.equals("f") || option.equals("l"));
    }

	public List getFilters(){
        List<Filter> filters = new LinkedList<>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (isOption(arg) && !isFileOption(arg)) {
                arg = ArgsParser.replace(arg);
                if(!isFormat(arg)){
                    Filter filter = new Filter(arg,args[i+1]);
                    filters.add(filter);
                }
            }
        }
		return filters;
	}

    public Format getFormat(){
        for (int i = 0; i < args.length ; i++) {
            String arg = args[i];
            if (isOption(arg) && !isFileOption(arg)) {
                arg = ArgsParser.replace(arg);
                if(isFormat(arg))
                    return new Format(arg);
            }
        }
       return new Format("f");
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