import java.util.Random;

public class Car {

	private final String carName;
	private int carMileage;

	public Car(String carName) {
		this.carName = carName;
		this.carMileage = 0;
	}

	public String getCarName() {
		return carName;
	}

	// 자동차 전진 여부 적용
	public void applyForwardOrNot() {
		if (4 <= new Random(System.nanoTime()).nextInt(10)) {
			this.carMileage++;
		}
	}

	// 자동차 현재 주행거리 표시
	public void printCurrentCarMileage() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carName).append(" : ");
		for (int i = 0; i < this.carMileage; i++) {
			stringBuilder.append("-");
		}
		System.out.println(stringBuilder.toString());
	}

	// 자동차 이름 검증
	public static boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	public static boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

	// 자동차 우승 여부 얻기
	public boolean isWinner(int playCount) {
		return this.carMileage == playCount;
	}

}
