import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidInputString {
	private final String splitStr = ",";
	private String inputStr;
	
	
	public ValidInputString(String inputStr) {
		this.inputStr = inputStr;
	}
	
	public String[] splitInputString() {
		String[] resStrs = inputStr.split(splitStr);
		return resStrs;
	}
}
