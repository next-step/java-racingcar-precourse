package racinggame;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class CarInput {
	static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String DELIMITER = ",";

	private CarInput() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/10 3:48 오후
	 * @Description : 자동차 이름에 대한 사용자의 입력을 받음
	 *
	 **/
	public static List<String> getInput() throws NoSuchElementException, IllegalStateException {
		System.out.println(GUIDE_MESSAGE);
		List<String> inputs = Arrays.asList(Console.readLine().split(DELIMITER));
		for (String input : inputs)
			if (Car.isOverThanFiveLetters(input))
				return getInput();
		return inputs;
	}
}
