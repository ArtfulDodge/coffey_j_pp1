import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reads the given file and passes the data line by line to IpMatcher, then outputs the results.
 * @author Joshua Coffey
 * @version 1.0
 * Programming Project One
 * CS322 Compiler Construction
 * Spring 2019
 */
public class Main {

	public static void main(String[] args) {
		long lines = 0;
		IpMatcher im = new IpMatcher();
		try {
			Scanner scan = new Scanner(new File(args[0]));
			while (scan.hasNextLine()) {
				im.processString(scan.nextLine());
				lines++;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		if (args[1].equals("1")) {
			im.getIpMap().forEach((k,v)->System.out.println(k + ": " + v));
		}
		if (args[1].equals("2")) {
			im.getUnameMap().forEach((k,v)->System.out.println(k + ": " + v));
		}

		System.out.println();
		System.out.println("Paresed " + lines + " lines from the source file");
		System.out.println("Found " + im.getIpMapSize() + " unique IPs");
		System.out.println("Found " + im.getUnameMapSize() + " unique users");

	}//end main

}//end Main.java
