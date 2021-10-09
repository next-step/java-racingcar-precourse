package exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class name_Exception {

	private static final int MAX_CAR_NAME_LENGTH=5;
	
	public static boolean isNum(String str) {
		if(str==null){
			return false;
		}
		
		try {
			double d=Double.parseDouble(str);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
	
	

	public static boolean validate_CarName(String str) {
		
		
		if(str.length()<MAX_CAR_NAME_LENGTH) {
			return false;
		}
		
		return true;
	}	
	
		
	public static boolean car_name_sort(String str) {
		
		String[] cars=str.split(",");
		int i=0;
		int n=cars.length;
		if(duplicated_name(str,n)) {
			return false;
		}
		
		while(i<n-1 && validate_CarName(cars[i])) {
			i++;
		}
		
		return validate_CarName(cars[i]);
	
		
	}
	
	
	
	public static boolean duplicated_name(String str, int n) {
		Set<String> set=new HashSet<>(Arrays.asList(str.split(",")));
		if(n != set.size()){
			return true;
		}
	
		return false;
	}
	
	
	
}