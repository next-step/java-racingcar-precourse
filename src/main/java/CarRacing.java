import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {
	private static Cars GAME_CARS;
	private static int GAME_COUNT;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름이르 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		GAME_CARS = makeCars(scanner.nextLine());

		System.out.println("시도할 회수는 몇회인가요?");
		GAME_COUNT = scanner.nextInt();
		System.out.println("실행결과");

		printRacing();
		printWinner(getWinners(GAME_CARS));
	}

	public static Cars makeCars(String carNames) {
		return new Cars(carNames);
	}

	public static String printPosition(int position) {
		return IntStream.range(0, position).mapToObj(i -> "-").collect(Collectors.joining());
	}

	public static Cars getWinners(Cars cars) {
		Cars winnerCars = new Cars();
		int winnerPosition = 0;
		for (Car car : cars.getCars()) {
			if (winnerPosition < car.position) {
				winnerPosition = car.position;
			}
		}

		for (Car car : cars.getCars()) {
			if (winnerPosition == car.position) {
				winnerCars.addCar(car);
			}
		}
		return winnerCars;
	}

	public static void printWinner(Cars winnerCars) {
		for (Car car : winnerCars.getCars()) {
			System.out.print(car.name);
		}

		System.out.print("가 최종 우승했습니다.");
	}

	public static void printRacing() {
		for (int i = 0; i < GAME_COUNT; i++) {
			GAME_CARS.getCars().forEach(car -> {
				car.move();
				System.out.println(car.name + ":" + printPosition(car.position));
			});
			System.out.println("");
		}
	}
}
