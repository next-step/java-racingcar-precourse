package racinggame.view;

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
}
