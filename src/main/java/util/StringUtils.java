package util;

public class StringUtils {
	public static void validateEmptyString(String input) {
		if (isEmpty(input)) {
			throw new IllegalArgumentException("빈 공백 혹은 값을 입력하지 않았습니다");
		}
	}

	public static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
