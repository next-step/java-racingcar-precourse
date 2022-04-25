package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import racingcar.utils.Error;

public class Name {
	private final String GAP = "\\s";

	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 5;

	private String name;

	private Name() {
	}

	public Name(String name) {
		validSize(name);
		validGap(name);

		this.name = name;
	}

	private void validGap(String name) {
		Pattern pattern = Pattern.compile(GAP);
		Matcher matcher = pattern.matcher(name);

		if(matcher.find()) {
			throw new IllegalArgumentException(Error.INVALID_TEXT_NAME.getMessage());
		}
	}

	private void validSize(String name) {
		int nameLength = name.length();

		if(nameLength < MIN_NAME_LENGTH || MAX_NAME_LENGTH < nameLength) {
			throw new IllegalArgumentException(Error.INVALID_NAME_LENGTH.getMessage());
		}
	}

	public String getName() {
		return name;
	}
}
