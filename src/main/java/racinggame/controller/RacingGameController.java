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
	private RacingParticipant racingParticipant;
	private Round round;


	public void askUserCarName(GameConsole gameConsole){
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


	public void askUserRound(GameConsole gameConsole){
		boolean isFinish = false;
		String round;
		do{
			round = gameConsole.readLine();
			isFinish = RoundValidator.checkPipeline(round);
		}while(!isFinish);
		this.round = new Round(Integer.parseInt(round));
	}

	public void runGame(GameConsole gameConsole){
		for(int i = 0; i < this.round.getRound(); i++){
			addTimeStep();
			drawTimeStep(gameConsole);
		}
		showResult();
	}

	private void addTimeStep(){
		List<Car> cars = racingParticipant.getCars();
		cars.forEach(car -> car.move());
	}

	private void drawTimeStep(GameConsole gameConsole){
		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars){
			gameConsole.printLine(drawCarPosition(car));
		}
		gameConsole.makeInterval();
	}

	private String drawCarPosition(Car car){
		String res = car.getName() + " : ";
		for(int i = 0; i < car.getPosition(); i++){
			res += "-";
		}
		return res;
	}

	private void showResult(){
		int maxPosition = getMaxPosition();
		String winner = getWinner(maxPosition);
		System.out.println("최종 우승자는 " + winner + " 입니다.");
	}

	private int getMaxPosition(){
		List<Car> cars = racingParticipant.getCars();
		int max = -1;
		for (Car car : cars){
			max = max < car.getPosition() ? car.getPosition() : max;
		}
		return max;
	}

	private String getWinner(int maxPosition){
		List<String> res = new ArrayList<>();

		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars) {
			comparePosition(res, car, maxPosition);
		}
		String[] ans = res.toArray(new String[res.size()]);
		return String.join(",", ans).replaceAll(" ", "");
	}

	private void comparePosition(List<String> target, Car car, int maxPosition){
		if (car.getPosition() == maxPosition) {
			target.add(car.getName());
		}
	}
}
