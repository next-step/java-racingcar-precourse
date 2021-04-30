import java.util.List;
import java.util.Map;
import java.util.Set;

public class SplitString {
	private final String SPLIT_STR = ",";
	private String inputStr;
	
	public SplitString(String inputStr) {
		this.inputStr = inputStr;
	}
	
	public String[] getSplitString() {
		String[] resStrs = inputStr.split(SPLIT_STR);
		return resStrs;
	}
}
