package racinggame;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class CarNameInput {
	private static List<String> carNames;
	static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하입니다. 다시 입력해주세요.";
	private final String DELIMITER = ",";
	private final int INPUT_LIMIT = 5;

	private CarNameInput() {
		carNames = getInput();
	}

	public static CarNameInput init() {
		return new CarNameInput();
	}

	public static List<String> values() {
		return carNames;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/10 3:48 오후
	 * @Description : 자동차 이름에 대한 사용자의 입력을 받음
	 *
	 **/
	private List<String> getInput() throws NoSuchElementException, IllegalStateException {
		System.out.println(GUIDE_MESSAGE);
		List<String> inputs = Arrays.asList(Console.readLine().split(DELIMITER));
		for (String input : inputs)
			if (isOverThanFiveLetters(input))
				return getInput();
		return inputs;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/10 3:48 오후
	 * @Description :사용자의 입력값 중 다섯 글자 이상의 자동차 이름이 포함되었는 지를 검증하는 메소드
	 *
	 **/
	private boolean isOverThanFiveLetters(String input) {
		if (input.length() > INPUT_LIMIT) {
			System.out.println(ERROR_MESSAGE);
			return true;
		}
		return false;
	}
}
