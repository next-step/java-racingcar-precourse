package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

import java.util.regex.Pattern;

/**
 * 입력 받는 시도 횟수 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class TryCount {
	private static final String TRY_INPUT_PATTERN = "^[1-9]([0-9])*$";
	public int tryCount;

	public TryCount(String tryCountStr) {
		patternCheck(tryCountStr);
		int tryCount = Integer.parseInt(tryCountStr);
		positiveCheck(tryCount);
		this.tryCount = tryCount;
	}

	public TryCount(int tryCount) {
		positiveCheck(tryCount);
		this.tryCount = tryCount;
	}

	public TryCount() {
		this.tryCount = 1;
	}

	public int getTryCount() {
		return tryCount;
	}

	/**
	 * 입력받은 문자열 숫자 패턴 검사
	 *
	 * @param input 입력받은 문자열
	 */
	private void patternCheck(String input) {
		if (!Pattern.matches(TRY_INPUT_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_TRY_COUNT);
		}
	}

	/**
	 * 입력받은 문자열 양수 검사
	 *
	 * @param input 입력받은 문자열
	 */
	private void positiveCheck(int input) {
		if (input <= 0) {
			throw new IllegalArgumentException(ERROR_TRY_COUNT);
		}
	}
}
