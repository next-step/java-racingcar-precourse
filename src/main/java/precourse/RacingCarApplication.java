package precourse;

import precourse.car.RacingCarFactory;
import precourse.car.RacingCarNameSequence;
import precourse.car.RacingCars;
import precourse.race.CarRace;
import precourse.race.CarRaceMessage;
import precourse.race.CarRaceAttemptNumber;
import precourse.race.CarRaceWinners;
import precourse.utility.ConsoleUI;

import java.util.Scanner;

public class RacingCarApplication {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		RacingCarNameSequence racingCarNameSequence = receiveCarNameSequence();
		CarRaceAttemptNumber attemptNumber = receiveAttemptNumber();
		RacingCars racingCars = RacingCarFactory.createNewCars(racingCarNameSequence);

		CarRace carRace = new CarRace(racingCars, attemptNumber);
		CarRaceWinners carRaceWinners = carRace.start();
		String winners = carRaceWinners.getWinners();
		ConsoleUI.show(winners + "가 최종 우승했습니다.");
	}

	private static CarRaceAttemptNumber receiveAttemptNumber() {
		try {
			ConsoleUI.show(CarRaceMessage.ASK_ATTEMPT_NUMBER);
			String attemptNumber = scanner.next();
			return new CarRaceAttemptNumber(attemptNumber);
		} catch (IllegalArgumentException e) {
			ConsoleUI.show(e.getMessage());
			return receiveAttemptNumber();
		}
	}

	private static RacingCarNameSequence receiveCarNameSequence() {
		try {
			ConsoleUI.show(CarRaceMessage.ASK_CAR_NAMES_AS_STRING);
			String carNameString = scanner.next();
			return new RacingCarNameSequence(carNameString);
		} catch (IllegalArgumentException e) {
			ConsoleUI.show(e.getMessage());
			return receiveCarNameSequence();
		}
	}

}
