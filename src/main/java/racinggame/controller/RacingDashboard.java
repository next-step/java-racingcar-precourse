package racinggame.controller;

import racinggame.view.GameConsole;

public class RacingDashboard {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String EXECUTION_RESULT = "실행결과";

	private GameConsole gameConsole;
	private RacingGameController gameManager;


	public RacingDashboard(){
		this.gameConsole = new GameConsole();
		this.gameManager = new RacingGameController();
	}

	public void startGame(){
		this.gameConsole.printLine(RacingDashboard.CAR_NAME_INPUT_MESSAGE);
		this.gameManager.askUserCarName(this.gameConsole);

		this.gameConsole.printLine(RacingDashboard.ROUND_INPUT_MESSAGE);
		this.gameManager.askUserRound(this.gameConsole);

		this.gameConsole.printLine(RacingDashboard.EXECUTION_RESULT);
		this.gameManager.runGame(this.gameConsole);
	}
}
