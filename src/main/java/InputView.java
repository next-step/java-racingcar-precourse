import java.util.Scanner;

public class InputView {
	public static RacingCars racingCarNamesView() {
		Scanner scanner = new Scanner(System.in);
		RacingCars cars = null;
		while (RacingCars.isNull(cars)) {
			cars = inputRacingCarNames(scanner);
		}
		return cars;
	}

	public static RacingCars inputRacingCarNames(Scanner scanner) {
		RacingCars cars = null;
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			cars = new RacingCars(splitCarNames(scanner.nextLine()));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return cars;
	}

	public static String[] splitCarNames(String carNames) {
		return carNames.replaceAll(" ", "").split(",");
	}

	public static RunCount runCountView() {
		Scanner scanner = new Scanner(System.in);
		return inputRunCount(scanner);
	}

	private static RunCount inputRunCount(Scanner scanner) {
		System.out.println("시도할 회수는 몇회인가요?");
		return new RunCount(scanner.nextLine());
	}
}
