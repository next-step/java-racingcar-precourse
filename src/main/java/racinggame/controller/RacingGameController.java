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
	}

	private int getTryCount() {
		int tryCountValue;
		while (true) {
			consoleView.println(COUNT_INPUT_MESSAGE);
			String tryCountString = consoleView.readLine();
			if (ValidationUtil.validOnlyNumber(tryCountString)) {
				tryCountValue = Integer.parseInt(tryCountString);
				break;
			}
		}
		return tryCountValue;
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
