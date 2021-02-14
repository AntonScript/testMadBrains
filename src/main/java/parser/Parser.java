package parser;

import java.util.*;

public class Parser implements IParser{
    private String parseStr;
    private Set<String> specialSymbols = new HashSet<>();

    public Parser(String parseStr) {
        this.parseStr = parseStr;

        //init cpec char
        specialSymbols.add(",");
        specialSymbols.add(".");
        specialSymbols.add(":");
        specialSymbols.add(";");
        specialSymbols.add("(");
        specialSymbols.add(")");
        specialSymbols.add("{");
        specialSymbols.add("}");
        specialSymbols.add(",");
        specialSymbols.add("-");
        specialSymbols.add("~");
        specialSymbols.add("\n");
    }

    @Override
    public void clearLine() {
        for (String c: specialSymbols) {
            parseStr = parseStr.replace(c," ");
        }
        parseStr = parseStr.replaceAll("\\s{2,}", " ").trim().toLowerCase();
    }

    @Override
    public Map<String, Integer> countingUniqueWords() {
        Map<String,Integer> res = new TreeMap<>();
        String item = "";

        for (int i = 0; i < parseStr.length(); i++) {
            if(parseStr.charAt(i) == ' '){
                if(item != ""){
                    if(res.containsKey(item)){
                        int value = res.get(item);
                        value++;
                        res.put(item,value);

                    }
                    else {
                        res.put(item,1);
                    }
                    item ="";

                }
            }
            else {
                item+=parseStr.charAt(i);
            }
        }
        return  res;
    }
}
