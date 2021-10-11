package racinggame.view;

import nextstep.utils.Console;

public class ConsoleView {

	public static final String ERROR = "[ERROR]";

	public String readLine() {
		return Console.readLine();
	}

	public void println(String message) {
		System.out.println(message);
	}

	public void printError(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}
}
