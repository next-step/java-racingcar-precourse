package precourse;

import java.util.Scanner;

import precourse.car.RacingCarFactory;
import precourse.car.RacingCarNameString;
import precourse.car.RacingCars;
import precourse.race.CarRace;
import precourse.race.CarRaceMessage;
import precourse.race.CarRaceTryNumber;
import precourse.race.CarRaceWinners;
import precourse.utility.ConsoleUI;

public class RacingCarApplication {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		RacingCarNameString racingCarNameString = receiveCarNameString();
		CarRaceTryNumber tryNumber = receiveTryNumber();
		RacingCars racingCars = RacingCarFactory.createNewCars(racingCarNameString);

		CarRace carRace = new CarRace(racingCars, tryNumber);
		CarRaceWinners carRaceWinners = carRace.start();
		String winners = carRaceWinners.getWinners();
		ConsoleUI.show(winners + "가 최종 우승했습니다.");
	}

	private static CarRaceTryNumber receiveTryNumber() {
		try {
			ConsoleUI.show(CarRaceMessage.ASK_TRY_NUMBER);
			String tryNumber = scanner.next();
			return new CarRaceTryNumber(tryNumber);
		} catch (IllegalArgumentException e) {
			ConsoleUI.show(e.getMessage());
			return receiveTryNumber();
		}
	}

	private static RacingCarNameString receiveCarNameString() {
		try {
			ConsoleUI.show(CarRaceMessage.ASK_CAR_NAMES_AS_STRING);
			String carNameString = scanner.next();
			return new RacingCarNameString(carNameString);
		} catch (IllegalArgumentException e) {
			ConsoleUI.show(e.getMessage());
			return receiveCarNameString();
		}
	}

}
