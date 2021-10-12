package racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import nextstep.utils.Console;
import racinggame.domain.CarName;

public class CarInput {
	public static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String DELIMITER = ",";

	private CarInput() {
	}

	public static List<String> getInput() throws NoSuchElementException, IllegalStateException {
		System.out.println(GUIDE_MESSAGE);
		List<String> inputs = Arrays.asList(Console.readLine().split(DELIMITER));
		for (String input : inputs)
			if (CarName.isOverThanFiveLetters(input))
				return getInput();
		return inputs;
	}
}
