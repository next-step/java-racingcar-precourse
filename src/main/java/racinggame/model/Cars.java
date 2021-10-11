package racinggame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Cars {
	public List<Car> cars = new ArrayList<Car>();

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	/**
	 * 자동차 이름 입력
	 * @param carNames 자동차 이름 어레이
	 * */
	public void addCars(String[] carNames) throws IllegalArgumentException {
		if (carNames == null || carNames.length == 0) {
			throw new IllegalArgumentException("[ERROR]");
		}

		for (String carName : carNames) {
			this.addCar(carName);
		}
	}

	private void addCar(String carName) {
		Car car = new Car();
		car.setCarName(carName);

		cars.add(car);
	}
	
	/**
	 * 자동차 이동 / 정지 
	 * */
	public void moveOrStop() {
		for (Car car : cars) {
			car.moveOrStop();
		}
	}
	
	/**
	 * 현재 위치 print
	 * */
	public void printPosition() {
		for (Car car : cars) {
			car.printPosition();
		}
	}
	
	/**
	 * 우승자 출력
	 * */
	public void printWinner() {
		int max = maxCarDistance();

		String winners = "";

		for (Car car : cars) {
			winners += isMaxThenGetString(car, max);
		}

		winners = winners.substring(1, winners.length());

		System.out.println("최종 우승자는 " + winners + " 입니다.");
	}
	
	private String isMaxThenGetString(Car car, int max) {
		if (car.getCarDistanceLength() == max) {
			return "," + car.getCarName().getCarName();
		}

		return "";
	}

	private int maxCarDistance() {
		int num = 0;
		for (Car car : cars) {
			num = max(car.getCarDistanceLength(), num);
		}

		return num;
	}
	
	private int max(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}

		return num2;
	}
}
