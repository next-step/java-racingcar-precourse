package racing.game.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racing.game.properties.RacingSystemProperties;

public class Validator {
	public static boolean isUnder5Character(String eachName) {
		return eachName.length() <= RacingSystemProperties.VALIDATE_CAR_NAME_MAX_LENGTH;
	}

	public static boolean isNumeric(String inputString) {
		Pattern pattern = Pattern.compile("\\d+$");
		Matcher matcher = pattern.matcher(inputString);

		return matcher.matches();
	}

	public static boolean isNotEmpty(String trimedText) {
		return !trimedText.isEmpty();
	}
}
