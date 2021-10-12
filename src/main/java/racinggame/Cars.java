package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final String SPLIT_KEY_WORD = ",";
	private final List<Car> racers;

	public Cars() {
		this.racers = initializeCarName();
	}

	private List<Car> initializeCarName() {
		userInputCarNames();
		List<Car> cars = null;
		while (cars == null) {
			cars = makeCars();
		}
		return cars;
	}

	private List<Car> makeCars() {
		List<Car> cars;
		List<String> names = Arrays.asList(Console.readLine().split(SPLIT_KEY_WORD));
		try {
			cars = addAllCar(names);
		} catch (Exception e) {
			System.out.println("[ERROR]" + e.getMessage());
			return null;
		}
		return cars;
	}

	private List<Car> addAllCar(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public int getNumberOfCars() {
		return racers.size();
	}

	public void race() {
		userInputRaceNumber();
		inRace(getRaceCount());
	}

	private void inRace(int count) {
		printStartMsg();
		while (count-- > 0) {
			racing();
			printNewLine();
		}
	}

	private int getRaceCount() {
		int count;
		do {
			count = stringToInt(Console.readLine());
		} while (count == 0);
		return count;
	}

	private int stringToInt(String inputNumber) {
		int count;
		try {
			count = Integer.parseInt(inputNumber);
		} catch (Exception e) {
			throw new NumberFormatException("0 이상의 숫자를 입력해주시기 바랍니다.");
		}
		return count;
	}

	private void racing() {
		for (Car car : this.racers) {
			car.race(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			car.printCarResults();
		}
	}

	private void userInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
	}

	private void userInputRaceNumber() {
		System.out.println("시도할 회수는 몇 회인가요?");
	}

	private void printWinner(String msg) {
		System.out.println("최종 우승자는 " + msg + "입니다.");
	}

	private void printNewLine() {
		System.out.println("");
	}

	private void printStartMsg() {
		System.out.println("실행 결과");
	}
}
