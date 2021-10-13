package racinggame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class InputView {

	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	public List<String> inputCarNames(){
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		String input = Console.readLine();

		return parse(input);
	}

	public int inputRound(){
		System.out.println(ROUND_INPUT_MESSAGE);
		String input = Console.readLine();
		return Integer.parseInt(input);
	}

	private List<String> parse(final String carNames) {
		return new ArrayList<>(Arrays.asList(carNames.split(",")));
	}
}
