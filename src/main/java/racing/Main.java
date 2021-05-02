package racing;

import java.util.Scanner;

import racing.race.Race;
import racing.race.RaceRecord;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		Scanner scanner = new Scanner(System.in);
		console.printOnBeforeInputCarNames();
		String carNames = scanner.next();
		console.printOnBeforeInputTryCount();
		int tryCount = scanner.nextInt();

		Race race = new Race(carNames, tryCount);
		RaceRecord raceRecord = race.startRace();
		console.println(raceRecord.toMessage());
	}
}
