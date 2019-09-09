import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class IpMatcher{

    //Default constructor
    public IpMatcher() {

    }// end default constructor

    public String readFile() {
        String result = "";
        //BufferedReader reader;
        URL url = IpMatcher.class.getResource("auth.log");
        try {
            /*reader = new BufferedReader(new FileReader(url.toString().substring(5)));
            String line = reader.readLine();
            while (line != null) {
                result += line + "\n";
                line = reader.readLine();
            }
            reader.close();*/
            result = new Scanner(new File(url.toString().substring(5))).useDelimiter("\\Z").next();
        } catch(IOException e){
            e.printStackTrace();
        }

        return result;
    }
	
}//ent IpMatcher.java
