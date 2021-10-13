package racinggame.view;

import racinggame.CarNames;
import racinggame.ProgressBars;

public class OutputView {
	/**
	 * View
	 * 1. 자동차 이름 입력 (반환타입: CarNames)
	 * 2. 시도횟수 입력 (반환타입: PlayCount)
	 * 3. 진행상황 출력
	 * 4. 우승자 출력
	 */

	public static void outputProgress(ProgressBars progressBars) {
		System.out.println(progressBars + "\n");
	}

	public static void outputProgressLabel() {
		System.out.println("실행 결과");
	}

	public static void outputResult(CarNames winnerNames) {
		System.out.println("최종 우승자는 " + winnerNames + " 입니다.");
	}

	public static void outputError(String errorMessage) {
		System.out.println("[ERROR] " + errorMessage);
	}
}
