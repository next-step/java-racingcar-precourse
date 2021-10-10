package racinggame;

import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class CycleInput {
	private static Cycle cycle;
	static final String GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
	static final String ERROR_MESSAGE = "1 이상의 숫자를 입력해주세요.";

	private CycleInput() {
		cycle = new Cycle(getInput());
	}

	public static CycleInput init() {
		return new CycleInput();
	}

	public static Cycle value() {
		return cycle;
	}

	private int getInput() throws NoSuchElementException, IllegalStateException {
		System.out.println(GUIDE_MESSAGE);
		String readLine = Console.readLine();
		if (!isMoreThanOne(readLine)) {
			System.out.println(ERROR_MESSAGE);
			return getInput();
		}
		return Integer.parseInt(readLine);
	}

	private boolean isMoreThanOne(String readLine) {
		try {
			return Integer.parseInt(readLine) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
