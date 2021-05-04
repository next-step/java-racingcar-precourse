package app;

import java.util.Scanner;

public class Reader {
	
	private static Reader reader = null;
	private static Scanner sc = null;
	
	public static Reader getInstance() {
		if(sc == null) {
			return new Reader(); 
		}
		return reader;
	} 

	public Reader() {
		sc = new Scanner(System.in);
	}

	public static String readLine() {
		return sc.nextLine();
	}
	
	public static Integer readInt() {
		return sc.nextInt();
	}

}
