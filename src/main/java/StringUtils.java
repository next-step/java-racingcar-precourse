public class StringUtils {
	public static void validateEmptyString(String s) {
		if (isEmpty(s)) {
			throw new IllegalArgumentException("빈 공백 혹은 값을 입력하지 않았습니다");
		}
	}

	public static boolean isEmpty(String s) {
		return s == null || s.isEmpty();
	}
}
