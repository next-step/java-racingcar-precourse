package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private final List<Car> racers;
	private final int raceCount;

	public Cars(List<String> names, String number) {
		this.racers = initializeCarName(names);
		this.raceCount = initializeRaceCount(number);
	}

	private int initializeRaceCount(String number) {
		int count;
		try {
			count = Integer.parseInt(number);
		}catch(Exception e){
			throw new NumberFormatException("숫자를 입력해주시기 바랍니다.");
		}
		return count;
	}

	private List<Car> initializeCarName(List<String> names) {
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
		int count = this.raceCount;
		printStartMsg();
		while(count-- > 0){
			racing();
			printNewLine();
		}
		printEndMsg("");
	}

	private void racing() {
		for (Car car : this.racers) {
			car.race(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			car.printCarResults();
		}
	}

	private void printEndMsg(String msg) {
		System.out.println("최종 우승자는 " + msg + "입니다.");
	}

	private void printNewLine() {
		System.out.println("");
	}

	private void printStartMsg() {
		System.out.println("실행 결과");
	}
}
