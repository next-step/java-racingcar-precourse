package racingcar.view;


import racingcar.exception.CarException;

public class OutputView {
	public static void printGameResultString() {
		System.out.println("실행 결과");
	}

	public static void printBlankLine() {
		System.out.println("");
	}

	public static void printCarMoveResult(String moveResult) {
		System.out.println(moveResult);
	}

	public static void printGameWinner(String winner) {
		System.out.println("최종 우승자 : " + winner);
	}

	public static void printErrorMessage(CarException carException) {
		System.out.println(carException.getMessage());
	}
}
