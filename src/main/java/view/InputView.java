package view;

import java.io.IOException;
import java.util.Scanner;

import utils.InputReader;
import utils.Validation;

public class InputView {
	public static final String INPUT_ASK_CARNAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_ASK_ROUNDCOUNT = "시도할 회수는 몇 회 인가요?";
	private static final Scanner InputScanner = new Scanner(System.in);

	private static String[] carNames;
	private static int roundCount;

	public static void askCarNames() throws IOException {
		String inputRoundStr;
		do {
			System.out.println(INPUT_ASK_CARNAMES);
			inputRoundStr = InputReader.getInput();
			setCarNames(inputRoundStr.split(","));
		} while (!Validation.validateCarName(carNames));
	}

	public static void askRoundCount() throws IOException {
		String inputRoundStr;
		do {
			System.out.println(INPUT_ASK_ROUNDCOUNT);
			inputRoundStr = InputReader.getInput();
		} while (!Validation.validateRoundCount(inputRoundStr));
		setRountCount(Integer.parseInt(inputRoundStr));
	}

	public static int getRoundCount() {
		return roundCount;
	}

	public static void setRountCount(int roundCount) {
		InputView.roundCount = roundCount;
	}

	public static String[] getCarNames() {
		return carNames;
	}

	public static void setCarNames(String[] carNames) {
		InputView.carNames = carNames;
	}
}
