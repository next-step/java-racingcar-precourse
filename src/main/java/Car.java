import java.util.Random;

public class Car {

	private static final String CAR_NAMES_SPLITTER = " : ";
	private static final String CAR_MILEAGE_CHARACTER = "-";

	private static final int CAR_NAME_LENGTH_MAX = 5;
	private static final int CAR_NAME_LENGTH_MIN = 1;
	private static final int MINIMUM_NUMBER_CAR = 2;
	private static final int RANDOM_VALUE_MAX = 10;
	private static final int FORWARD_CONDITIONS_VALUE = 4;

	private final String carName;
	private int carMileage;

	public Car(String carName) {
		this.carName = carName;
		this.carMileage = 0;
	}

	public String getCarName() {
		return carName;
	}

	public int getCarMileage() {
		return carMileage;
	}

	private void increaseCarMileage() {
		this.carMileage++;
	}

	// 자동차 전진 여부 적용
	public void applyForwardOrNot() {
		if (FORWARD_CONDITIONS_VALUE <= new Random(System.nanoTime()).nextInt(RANDOM_VALUE_MAX)) {
			increaseCarMileage();
		}
	}

	// 자동차 현재 주행거리 표시
	public void printCurrentCarMileage() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carName).append(CAR_NAMES_SPLITTER);
		for (int i = 0; i < getCarMileage(); i++) {
			stringBuilder.append(CAR_MILEAGE_CHARACTER);
		}
		System.out.println(stringBuilder.toString());
	}

	// 자동차 이름 검증
	public static boolean isValidCarName(String carName) {
		return CAR_NAME_LENGTH_MAX >= carName.length() && CAR_NAME_LENGTH_MIN <= carName.length();
	}

	// 자동차 대수 검증
	public static boolean isValidCarCount(String[] carNameArr) {
		return MINIMUM_NUMBER_CAR <= carNameArr.length;
	}

	// 자동차 우승 여부 얻기
	public boolean isWinner(int raceCount) {
		return getCarMileage() == raceCount;
	}

}
