import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

/**
 * Processes the inpormation passed to it by Main, storing the Ips and the Usernames and how
 * frequently each unique one appears in hashmaps.
 * @author Joshua Coffey
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */
public class IpMatcher{

    private HashMap<String, Integer> ipMap;
    private HashMap<String, Integer> unameMap;

    /**
     * Constructor: initializes the HashMaps
     */
    public IpMatcher() {
        ipMap = new HashMap<>();
        unameMap = new HashMap<>();
    }// end constructor

    /**
     * Simple accessor, returns ipMap
     * @return ipMap
     */
    public HashMap<String, Integer> getIpMap() {
        return ipMap;
    }//end getIpMap

    /**
     * Simple accessor, returns unameMap
     * @return unameMap
     */
    public HashMap<String, Integer> getUnameMap() {
        return unameMap;
    }//end getUnameMap

    /**
     * Returns the size of ipMap
     * @return ipMap.size()
     */
    public int getIpMapSize() {
        return ipMap.size();
    }//end getIpMapSize

    /**
     * Returns the size of unameMap
     * @return unameMap.size()
     */
    public int getUnameMapSize() {
        return unameMap.size();
    }//end getUnameMapSize

    /**
     * Searches the given string for ip addresses and usernames, updating the relevant HashMaps if any are found
     * @param input The string to process
     */
    public void processString(String input) {
        Matcher ip = Pattern.compile("\\d+[.]\\d+[.]\\d+[.]\\d+").matcher(input);
        Matcher user = Pattern.compile("\\buser \\b[a-zA-Z0-9_-]+[$]?").matcher(input); //matching loosest linux user name constraints I found, and then loosening them a bit more
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
    }//end processString
	
}//end IpMatcher
