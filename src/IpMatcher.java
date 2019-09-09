import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class IpMatcher{

    private String fileName;
    private String fileText;
    private HashMap<String, Integer> ipMap;
    private HashMap<String, Integer> unameMap;
    private long lines;

    //constructor
    public IpMatcher(String filePath) {
        fileName = filePath;
        fileText = readFile();
        ipMap = new HashMap<>();
        unameMap = new HashMap<>();
        populateIps();
        populateUnames();
    }// end constructor

    private String readFile() {
        String result = "";
        try {
            result = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
            lines = Files.lines(Paths.get(fileName)).count();
        } catch(IOException e){
            e.printStackTrace();
        }

        return result;
    }

    public String getFileText() {
        return fileText;
    }

    public HashMap<String, Integer> getIpMap() {
        return ipMap;
    }

    public HashMap<String, Integer> getUnameMap() {
        return unameMap;
    }

    public long getLines() {
        return lines;
    }

    public void populateIps() {
        Matcher m = Pattern.compile("\\d+[.]\\d+[.]\\d+[.]\\d+").matcher(getFileText());
        while (m.find()) {
            String group = m.group();
            if (ipMap.containsKey(group)) {
                ipMap.put(group, ipMap.get(group)+1);
            } else {
                ipMap.put(group, 1);
            }
        }
    }

    public void populateUnames() {
        Matcher m = Pattern.compile("\\buser \\b[a-zA-Z0-9]+").matcher(getFileText());
        while (m.find()) {
            String group = m.group();
            group = group.substring(5);
            if (unameMap.containsKey(group)) {
                unameMap.put(group, unameMap.get(group)+1);
            } else {
                unameMap.put(group, 1);
            }
        }
    }
	
}//end IpMatcher.java
