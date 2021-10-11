package racinggame.view;

import racinggame.model.RacingGameStatus;
import racinggame.model.WinnerNames;

public class RacingGameView {
	
	public void printlnInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
	}
	
	public void printlnErrorMessage(Exception e) {
		System.out.println("[ERROR] " + e.getMessage());
	}
	
	public void printlnInputMaxMoveTurn() {
		System.out.println("시도할 회수는 몇회인가요?");
	}
	
	public void printlnRacingGameProgress() {
		System.out.println("\n실행 결과");
	}
	
	/**
	 * 레이싱 게임 진행과정 출력
	 * @param status RacingGameStatus 객체 - Cars 객체의 getStatus() 메소드로 획득.
	 */
	public void showRacingGameStatus(RacingGameStatus status) {
		System.out.println(status);
	}
	
	/**
	 * 레이싱 게임 진행결과 출력
	 * @param winnerNames WinnerNames 객체 - Cars 객체의 getWinnerNames() 메소드로 획득.
	 */
	public void printlnRacingGameResult(WinnerNames winnerNames) {
		System.out.printf("최종 우승자는 %s 입니다.\n", winnerNames);
	}
}
