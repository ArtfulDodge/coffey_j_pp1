public class Main {
	
	public static void main(String[] args) {
		IpMatcher im = new IpMatcher(args[0]);

		if (args[1].equals("1")) {
            im.getIpMap().forEach((k,v)->System.out.println(k + ": " + v));
        }
        if (args[1].equals("2")) {
            im.getUnameMap().forEach((k,v)->System.out.println(k + ": " + v));
        }

        System.out.println();
		System.out.println("Paresed " + im.getLines() + " lines from the source file");
		System.out.println("Found " + im.getIpMap().size() + " unique IPs");
		System.out.println("Found " + im.getUnameMap().size() + " unique users");
	}//end main

}//end Main.java
