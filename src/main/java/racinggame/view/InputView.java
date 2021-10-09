package racinggame.view;

import nextstep.utils.Console;

public class InputView {

	public String[] inputNames() {
		final String input = Console.readLine();
		return input.split(",");
	}

	public int inputNumber() {
		return Integer.parseInt(Console.readLine());
	}
}
