package racinggame.view;

import nextstep.utils.Console;
import racinggame.view.input.TryNumberInput;

public class ConsoleLog {
	private static final String TRY_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

	public static int getInputTryNumber() {
		System.out.println(TRY_COUNT_REQUEST_MESSAGE);
		return new TryNumberInput(Console.readLine()).getTryNumber();
	}
}
