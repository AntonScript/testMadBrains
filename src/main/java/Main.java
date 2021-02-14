import parser.IParser;
import parser.Parser;
import webscanner.IWebScanner;
import webscanner.WebScanner;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String url = "http://madbrains.github.io/java_course_test";
        IWebScanner webScanner = new WebScanner();
        IParser parser = new Parser(webScanner.parseWeb(url));
        parser.clearLine();
        Map<String,Integer> res = parser.countingUniqueWords();
        printResult(res);

    }

    public static void printResult(Map<String,Integer> res){
        int count = 0;
        Collection<Integer> values = res.values();
        for (Integer i: values) {
            count+=i;
        }
        System.out.println("уникальных слов: " + count);
        Set<String> keys = res.keySet();

        for (String key : keys) {
            System.out.println(key +" -> "+ res.get(key));
        }
    }

}
