package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class RacingGame {
	private static String GUIDE_RACING_CAR_NAME = "경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)";
	private static String GUIDE_RACING_GAME_COUNT = "시도할회수는몇회인가요?";
	private static String ERROR_RACING_CAR_NAME = "[ERROR] : 자동차 이름의 자리수는 1 ~ 5 자리로만 입력 가능합니다.";

	private int playGameCount = 0;
	private int championPosition = 0;
	private RacingCars racingCars;
	private List<String> championList = new ArrayList<>();

	public static RacingCars initRacingCars() {
		Boolean continueNextStep = true;
		String[] carNames;

		do {
			continueNextStep = true;
			System.out.println(GUIDE_RACING_CAR_NAME);
			carNames = Console.readLine().split(",");

			for(String carName : carNames) {
				if(!RacingGameUtils.validationCarName(carName)) {
					System.out.println(ERROR_RACING_CAR_NAME);
					continueNextStep = false;
					break;
				}
			}

		}while (!continueNextStep);

		return new RacingCars(carNames);
	}

	public static int initRacingGameCount() {
		System.out.println(GUIDE_RACING_GAME_COUNT);
		return Integer.parseInt(Console.readLine());
	}

	public RacingGame(RacingCars racingCars, int initGameCount) {
		this.racingCars = racingCars;
		this.playGameCount = initGameCount;
	}

	public void playRacingGame() {
		for(int round = 0; round < playGameCount; round++) {
			for(RacingCar racingCar : racingCars.getRacingCars()) {
				try{
					racingCar.moveCar(RacingGameUtils.getRandomNumber());
				}catch (Exception e) {
					e.getStackTrace();
					break;
				}

				System.out.println(racingCar.getName() + " : " + racingCar.convertPositionToString() + " ");
			}
			System.out.println("");
		}

		getRacingChampion();
	}

	public Boolean isChampion(RacingCar racingCar) {
		if(racingCar.getPosition() >= championPosition) {
			return true;
		}

		return false;
	}

	public void setChampionInfo(RacingCar racingCar) {
		int racingCarPosition = racingCar.getPosition();

		if(racingCarPosition == championPosition) {
			championList.add(racingCar.getName());
		}

		if(racingCarPosition > championPosition) {
			championPosition = racingCar.getPosition();
			championList.clear();
			championList.add(racingCar.getName());
		}
	}

	public void getRacingChampion() {
		for(RacingCar racingCar: racingCars.getRacingCars()) {
			if(isChampion(racingCar)) {
				setChampionInfo(racingCar);
			}
		}

		System.out.println("최종 우승자는 " + String.join(",", championList)  + " 입니다.");
	}
}
