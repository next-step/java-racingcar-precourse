package racinggame.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCarNames {
	private static final Pattern INPUT_FORMAT_PATTERN = Pattern.compile("^(?:[a-zA-Z0-9가-힣]{1,5},)*[a-zA-Z0-9가-힣]{1,5}$");
	private static final String EMPTY_STRING = "";
	private static final String SPLIT_DELIMITER = ",";

	private String inputString;

	public RacingCarNames(String inputString) {
		validateBlank(inputString);
		validateFormat(inputString);
		validateDuplication(inputString);
		this.inputString = inputString;
	}

	public String[] parse() {
		return parse(inputString);
	}

	private String[] parse(String inputString) {
		return inputString.split(SPLIT_DELIMITER);
	}

	private void validateDuplication(String inputString){
		String[] names = parse(inputString);
		int deDuplicatedSize = findDeduplicatedSize(names);
		if(names.length != deDuplicatedSize){
			throw new IllegalArgumentException("자동차 이름에 중복이 존재 합니다.");
		}
	}

	private void validateFormat(String inputString) {
		Matcher matcher = INPUT_FORMAT_PATTERN.matcher(inputString);
		if (!matcher.find()) {
			throw new IllegalArgumentException("입력 값은 콤마(,)로 구분된 길이 5 이하의 글자 어야 합니다.");
		}
	}

	private void validateBlank(String inputString) {
		if (Objects.isNull(inputString) || inputString.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException("입력 값이 존재 하지 않습니다.");
		}
	}

	private int findDeduplicatedSize(String[] names){
		Set<String> container = new HashSet<>(Arrays.asList(names));
		return container.size();
	}
}