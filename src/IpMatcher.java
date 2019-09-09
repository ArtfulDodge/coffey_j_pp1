/**
 * Reads the given file and searches for usernames and ip addresses
 * @author Joshua Coffey
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class IpMatcher{

    private HashMap<String, Integer> ipMap;
    private HashMap<String, Integer> unameMap;


    public IpMatcher() {
        ipMap = new HashMap<>();
        unameMap = new HashMap<>();
    }// end constructor

    public HashMap<String, Integer> getIpMap() {
        return ipMap;
    }

    public HashMap<String, Integer> getUnameMap() {
        return unameMap;
    }

    public int getIpMapSize() {
        return ipMap.size();
    }

    public int getUnameMapSize() {
        return unameMap.size();
    }

    public void processString(String input) {
        Matcher ip = Pattern.compile("\\d+[.]\\d+[.]\\d+[.]\\d+").matcher(input);
        Matcher user = Pattern.compile("\\buser \\b[a-zA-Z0-9]+").matcher(input);
        while (ip.find()) {
            String group = ip.group();
            if (ipMap.containsKey(group)) {
                ipMap.put(group, ipMap.get(group)+1);
            } else {
                ipMap.put(group, 1);
            }
        }
        while (user.find()) {
            String group = user.group();
            group = group.substring(5);
            if (unameMap.containsKey(group)) {
                unameMap.put(group, unameMap.get(group)+1);
            } else {
                unameMap.put(group, 1);
            }
        }
    }
	
}//end IpMatcher
