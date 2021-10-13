package racinggame.controller;

import racinggame.model.RacingParticipant;
import racinggame.model.car.Car;
import racinggame.model.round.Round;
import racinggame.model.validator.InputValidator;
import racinggame.model.validator.RoundValidator;
import racinggame.view.GameConsole;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String EXECUTION_RESULT = "실행결과";

	private RacingParticipant racingParticipant;
	private GameConsole gameConsole;
	private Round round;

	public RacingGameController(){
		this.gameConsole = new GameConsole();

	}

	public void startGame(){
		askUserCarName();
		askUserRound();
		runGame();
	}

	private void askUserCarName(){
		gameConsole.printLine(RacingGameController.CAR_NAME_INPUT_MESSAGE);
		boolean isFinish = false;
		String userText;
		do {
			userText = gameConsole.readLine();
			isFinish = InputValidator.validatePipeline(userText);
		}while(!isFinish);
		setRacingParticipants(userText);
	}

	private void setRacingParticipants(String input){
		List<Car> participants = new ArrayList<Car>();

		String[] inputs = input.split(",");
		for(int i = 0; i < inputs.length; i++){
			participants.add(new Car(inputs[i]));
		}

		this.racingParticipant = new RacingParticipant(participants);
	}


	private void askUserRound(){
		gameConsole.printLine(RacingGameController.ROUND_INPUT_MESSAGE);
		boolean isFinish = false;
		String round;
		do{
			round = gameConsole.readLine();
			isFinish = RoundValidator.checkPipeline(round);
		}while(!isFinish);
		this.round = new Round(Integer.parseInt(round));
	}

	private void runGame(){
		System.out.println("");
		gameConsole.printLine(RacingGameController.EXECUTION_RESULT);
		for(int i = 0; i < this.round.getRound(); i++){
			addTimeStep();
			drawTimeStep();
		}
		showResult();
	}

	private void addTimeStep(){
		List<Car> cars = racingParticipant.getCars();
		cars.forEach(car -> car.move());
	}

	private void drawTimeStep(){
		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars){
			System.out.print(car.getName() + " : ");
			for(int i = 0; i < car.getPosition(); i++){
				System.out.print("-");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void showResult(){
		int maxPosition = getMaxPosition();
		String winner = getWinner(maxPosition);
		System.out.println("최종 우승자는 " + winner + "입니다.");
	}

	private int getMaxPosition(){
		List<Car> cars = racingParticipant.getCars();
		int max = -1;
		for (Car car : cars){
			if(max < car.getPosition()){
				max = car.getPosition();
			}
		}
		return max;
	}

	private String getWinner(int maxPosition){
		String res = "";
		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars) {
			if (car.getPosition() == maxPosition) {
				res += car.getName();
				res += ",";
			}
		}
		return res;
	}
}
