package racinggame.view;

import racinggame.model.RacingGameStatus;

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
	
	public void showRacingGameStatus(RacingGameStatus status) {
		System.out.println(status);
	}
}
