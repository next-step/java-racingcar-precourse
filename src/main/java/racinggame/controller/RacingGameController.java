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

	/**
	 * 레이싱 참여 자동차의 이름 사용자 입력 요구
	 * @param GameConsole 사용자에게 입력받기 위한 인스턴스
	 */
	public void askUserCarName(GameConsole gameConsole){
		boolean isFinish = false;
		String userText;
		do {
			userText = gameConsole.readLine();
			isFinish = InputValidator.validatePipeline(userText);
		}while(!isFinish);
		setRacingParticipants(userText);
	}

	/**
	 * 사용자에게 입력받은 문자를 , 를 기준으로 분리 및 멤버에 등록
	 * @param String input 입력받은 raw한 문자열
	 */
	private void setRacingParticipants(String input){
		List<Car> participants = new ArrayList<Car>();

		String[] inputs = input.split(",");
		for(int i = 0; i < inputs.length; i++){
			participants.add(new Car(inputs[i]));
		}

		this.racingParticipant = new RacingParticipant(participants);
	}

	/**
	 * 총 진행 라운드 수 사용자에게 요구
	 * @param GameConsole 사용자에게 입력받기 위한 인스턴스
	 */
	public void askUserRound(GameConsole gameConsole){
		boolean isFinish = false;
		String round;
		do{
			round = gameConsole.readLine();
			isFinish = RoundValidator.checkPipeline(round);
		}while(!isFinish);
		this.round = new Round(Integer.parseInt(round));
	}

	/**
	 * 프로퍼티에 등록된 총 라운드 수만큼 게임 진행
	 * @param GameConsole 사용자에게 ui를 보여주기 위한 인스턴스
	 */
	public void runGame(GameConsole gameConsole){
		for(int i = 0; i < this.round.getRound(); i++){
			addTimeStep();
			drawTimeStep(gameConsole);
		}
		showResult();
	}

	/**
	 * 레이싱 참여 자동차들을 움직이게 하기 위한 메소드
	 * Car 클래스에 랜덤하게 이동하도록 구현
	 */
	private void addTimeStep(){
		List<Car> cars = racingParticipant.getCars();
		cars.forEach(car -> car.move());
	}

	/**
	 * 레이싱 참여 자동차들을 움직이게 하기 위한 메소드
	 * Car 클래스에 랜덤하게 이동하도록 구현
	 * @param GameConsole 사용자에게 ui를 보여주기 위한 인스턴스
	 */
	private void drawTimeStep(GameConsole gameConsole){
		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars){
			gameConsole.printLine(drawCarPosition(car));
		}
		gameConsole.makeInterval();
	}

	/**
	 * 차동차의 현재 위치를 그리기 위한 메서드
	 * @param Car 매개변수로 받은 자동차로 그림을 그려주는 대상
	 * @return String [참가자] : (- * 거리) 형태의 문자열
	 */
	private String drawCarPosition(Car car){
		String res = car.getName() + " : ";
		for(int i = 0; i < car.getPosition(); i++){
			res += "-";
		}
		return res;
	}

	/**
	 * 가장 멀리 간 자동차를 보여주는 메서드
	 */
	private void showResult(){
		int maxPosition = getMaxPosition();
		String winner = getWinner(maxPosition);
		System.out.println("최종 우승자는 " + winner + " 입니다.");
	}

	/**
	 * 가장 멀리간 거리를 계산하는 메서드 O(N)
	 * @return int maxPosition
	 */
	private int getMaxPosition(){
		List<Car> cars = racingParticipant.getCars();
		int max = -1;
		for (Car car : cars){
			max = max < car.getPosition() ? car.getPosition() : max;
		}
		return max;
	}

	/**
	 * 우승자를 찾는 메서드
	 * @param int maxPosition
	 * @return String winner ,를 기준으로 우승자를 리턴
	 */
	private String getWinner(int maxPosition){
		List<String> res = new ArrayList<>();

		List<Car> cars = racingParticipant.getCars();
		for(Car car : cars) {
			comparePosition(res, car, maxPosition);
		}
		String[] ans = res.toArray(new String[res.size()]);
		return String.join(",", ans).replaceAll(" ", "");
	}

	/**
	 * @param List<String> maxPosition에 해당하면 List에 추가하기 위한 인스턴스
	 * @param Car 비교를 하기위한 자동차 인스턴스
	 * @param int 비교하기 위한 최대의 위치
	 */
	private void comparePosition(List<String> target, Car car, int maxPosition){
		if (car.getPosition() == maxPosition) {
			target.add(car.getName());
		}
	}
}
