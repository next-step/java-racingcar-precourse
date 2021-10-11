package racinggame.controller;

import racinggame.model.GameResult;
import racinggame.service.RacingGameService;
import racinggame.utils.ValidationUtil;
import racinggame.view.ConsoleView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5이하로 입력하세요.";
	public static final String SEPARATOR = ",";
	public static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE_PREFIX = "최종 우승자는 ";
	public static final String WINNER_MESSAGE_SUFFIX = " 입니다.";
	public static final int DEFAULT_TRY_COUNT_VALUE = 0;
	private final ConsoleView consoleView;
	private final RacingGameService racingGameService;

	public RacingGameController(ConsoleView consoleView) {
		this.consoleView = consoleView;
		this.racingGameService = new RacingGameService();
	}

	public void startGame() {
		racingGameService.initCarList(toList(getCarNameArray()));
		racingGameService.initTryCount(getTryCount());
		GameResult gameResult = racingGameService.runRace();
		printResult(gameResult);
		printWinner(racingGameService.getWinner());
	}

	private void printWinner(String winner) {
		consoleView.println(WINNER_MESSAGE_PREFIX + winner + WINNER_MESSAGE_SUFFIX);
	}

	private int getTryCount() {
		int tryCountValue = DEFAULT_TRY_COUNT_VALUE;
		boolean isOnlyNumber;
		do {
			consoleView.println(COUNT_INPUT_MESSAGE);
			String tryCountString = consoleView.readLine();
			isOnlyNumber = ValidationUtil.validOnlyNumber(tryCountString);
			tryCountValue = setTryCountValue(tryCountValue, isOnlyNumber, tryCountString);
		} while (!isOnlyNumber);
		return tryCountValue;
	}

	private int setTryCountValue(int tryCountValue, boolean isOnlyNumber, String tryCountString) {
		if (isOnlyNumber) {
			tryCountValue = Integer.parseInt(tryCountString);
		}
		return tryCountValue;
	}

	private String[] getCarNameArray() {
		String[] carNameArray;
		boolean isCarNameBelow5;
		do {
			carNameArray = toArray(getCarsName());
			isCarNameBelow5 = ValidationUtil.validCarNameLength(carNameArray);
			printCarNameLengthError(isCarNameBelow5);
		} while (!isCarNameBelow5);
		return carNameArray;
	}

	private void printCarNameLengthError(boolean isCarNameBelow5) {
		if (!isCarNameBelow5) {
			consoleView.printError(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private String[] toArray(String string) {
		return string.split(SEPARATOR);
	}

	private List<String> toList(String[] stringArray) {
		return Arrays.asList(stringArray);
	}

	private String getCarsName() {
		consoleView.println(CAR_NAME_INPUT_MESSAGE);
		return consoleView.readLine();
	}

	private void printResult(GameResult gameResult) {
		consoleView.println(RESULT_MESSAGE);
		List<String> resultList = gameResult.getResultList();
		for (String s : resultList) {
			consoleView.println(s);
		}
	}
}
