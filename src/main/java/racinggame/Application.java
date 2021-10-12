package racinggame;

public class Application {
	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame(Cars.init(CarInput.getInput()), Cycle.init(CycleInput.getInput()));
		racingGame.start();
	}
}
