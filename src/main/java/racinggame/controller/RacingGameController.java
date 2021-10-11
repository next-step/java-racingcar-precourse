package racinggame.controller;

import racinggame.model.CarEntry;
import racinggame.model.TryCount;
import racinggame.utils.ValidationUtil;
import racinggame.view.ConsoleView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5이하로 입력하세요.";
	public static final String RESULT_MESSAGE = "실행 결과";
	private CarEntry carEntry;
	private ConsoleView consoleView;
	private TryCount tryCount;

	public RacingGameController(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}

	public void startGame() {
		initCarList(getCarNameArray());
		initTryCount(getTryCount());
		runRace();
	}

	private void runRace() {
		while (!tryCount.isZeroCount()) {
			carEntry.race();
			printResult(carEntry.getResult());
			tryCount.decreaseCount();
		}
	}

	private void printResult(List<String> result) {
		consoleView.println(RESULT_MESSAGE);
		for (String s : result) {
			consoleView.println(s);
		}
	}

	private void initTryCount(int tryCountValue) {
		tryCount = new TryCount(tryCountValue);
	}

	private int getTryCount() {
		int tryCountValue;
		while (true) {
			consoleView.println("시도할 회수는 몇회인가요?");
			String tryCountString = consoleView.readLine();
			if (ValidationUtil.validOnlyNumber(tryCountString)) {
				tryCountValue = Integer.parseInt(tryCountString);
				break;
			}
		}
		return tryCountValue;
	}

	private void initCarList(String[] carNameArray) {
		carEntry = new CarEntry(toList(carNameArray));
	}

	private String[] getCarNameArray() {
		String[] carNameArray;
		while (true) {
			carNameArray = toArray(getCarsName());
			boolean isCarNameBelow5 = ValidationUtil.validCarNameLength(carNameArray);
			if (isCarNameBelow5) {
				break;
			}
			consoleView.printError(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
		return carNameArray;
	}

	private String[] toArray(String string) {
		return string.split(",");
	}

	private List<String> toList(String[] stringArray) {
		return Arrays.asList(stringArray);
	}

	private String getCarsName() {
		consoleView.println(CAR_NAME_INPUT_MESSAGE);
		return consoleView.readLine();
	}
}
