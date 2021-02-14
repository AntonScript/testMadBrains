package webscanner;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;
import java.util.Scanner;

public class WebScanner implements IWebScanner{
    @Override
    public String parseWeb(String url) {
        String result = null;
        try {
            URLConnection connection = new URL(url).openConnection();
            result = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
