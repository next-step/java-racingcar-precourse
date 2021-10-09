package racinggame.manage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Vaildating {
	
	private static final int CAR_NAME_MAX_LENGTH=5;
	
	public static boolean IsNum(String str) {
		if(str==null) {
			return false;
		}
		
		try {
			double d=Double.parseDouble(str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
	
	public static boolean CarName_len(String str) {
		if(str.length()>CAR_NAME_MAX_LENGTH) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean game_playing(String str) {
		String[] cars=str.split(",");
		int i=0;
		int n=cars.length;
		
		if(hasDuplicatedCarNum(str,n)) {
			return false;
		}
		while(i<n-1 && CarName_len(cars[i])) {
			i++;
		}
		
		return CarName_len(cars[i]);
		
	}
	
	public static boolean hasDuplicatedCarNum(String str, int n) {
		Set<String> set=new HashSet<>(Arrays.asList(str.split(",")));
		if(n!=set.size()) {
			return true;
		}
		
		return false;
		
	}
	

}
