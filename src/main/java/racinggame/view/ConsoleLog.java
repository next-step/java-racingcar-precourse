package racinggame.view;

import java.util.List;

import nextstep.utils.Console;
import racinggame.view.input.CarNameInput;
import racinggame.view.input.TryNumberInput;

public class ConsoleLog {
	private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRY_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

	public static List<String> getInputCarName() {
		System.out.println(CAR_NAME_REQUEST_MESSAGE);
		return new CarNameInput(Console.readLine()).getCarNames();
	}

	public static int getInputTryNumber() {
		System.out.println(TRY_COUNT_REQUEST_MESSAGE);
		return new TryNumberInput(Console.readLine()).getTryNumber();
	}
}
