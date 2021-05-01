package racing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		Scanner scanner = new Scanner(System.in);
		console.printOnBeforeInputCarNames();
		String carNames = scanner.next();
		console.printOnBeforeInputTryCount();
		int tryCount = scanner.nextInt();

		Race race = new Race(carNames, tryCount);
		RaceResult result = race.start();
		console.println(result.toMessage());
	}
}
