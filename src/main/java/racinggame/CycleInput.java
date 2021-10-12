package racinggame;

import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class CycleInput {
	static final String GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
	static final String ERROR_MESSAGE = "1 이상의 숫자를 입력해주세요.";

	private CycleInput() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:04 오전
	 * @Description : 몇 번 이동할지 사용자의 입력을 받음
	 *
	 **/
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
