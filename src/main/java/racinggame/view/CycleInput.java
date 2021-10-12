package racinggame.view;

import java.util.NoSuchElementException;

import nextstep.utils.Console;
import racinggame.domain.Cycle;

public class CycleInput {
	public static final String GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String ERROR_MESSAGE = "1 이상의 숫자를 입력해주세요.";

	private CycleInput() {
	}

	public static int getInput() throws NoSuchElementException, IllegalStateException {
		System.out.println(GUIDE_MESSAGE);
		String readLine = Console.readLine();
		if (!Cycle.isMoreThanOne(readLine)) {
			System.out.println(ERROR_MESSAGE);
			return getInput();
		}
		return Integer.parseInt(readLine);
	}
}
