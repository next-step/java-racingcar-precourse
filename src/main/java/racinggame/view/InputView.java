package racinggame.view;

import nextstep.utils.Console;

public class InputView {

	private static final String DELIMITER = ",";

	public String[] inputNames() {
		final String input = Console.readLine();
		return input.split(DELIMITER);
	}

	public int inputNumber() {
		return Integer.parseInt(Console.readLine());
	}
}
