package racinggame.view;

import nextstep.utils.Console;

public class User {
	public static final String INPUT_CAR_NAMES_MESSAGE =
		"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	private String carNames;
	private String moveCount;
	private boolean validatedCarName;

	public User() {
		this.validatedCarName = false;
	}

	public String getReadLineCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		this.carNames = Console.readLine();
		return carNames;
	}

	public String getReadLineMoveCount() {
		System.out.println(INPUT_MOVE_COUNT_MESSAGE);
		this.moveCount = Console.readLine();
		return moveCount;
	}

	public String getCarNames() {
		return carNames;
	}

	public void validatedCarName() {
		this.validatedCarName = true;
	}

	public boolean isValidatedCarName() {
		return validatedCarName == true;
	}
}
