import java.util.Random;

public class Car {

	private static final String MESSAGE_REQUIRES_MORE_THAN_ONE = "2대 이상의 자동차가 필요합니다.";
	private static final String MESSAGE_NAME_LENGTH_CONDITION_NOT_MET = "자동차 이름은 1~5자로 해주세요.";

	private static final String CAR_NAMES_SPLITTER = " : ";
	private static final String CAR_MILEAGE_CHARACTER = "-";

	private static final int CAR_NAME_LENGTH_MAX = 5;
	private static final int CAR_NAME_LENGTH_MIN = 1;
	private static final int MINIMUM_NUMBER_CAR = 2;
	private static final int RANDOM_VALUE_MAX = 10;
	private static final int FORWARD_CONDITIONS_VALUE = 4;

	private static final int VALID_CAR_NAME_FALSE = 1;
	private static final int VALID_CAR_NAME_TRUE = 0;

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
	public static int isValidCarName(String carName) {
		if (CAR_NAME_LENGTH_MAX >= carName.length() && CAR_NAME_LENGTH_MIN <= carName.length()) {
			return VALID_CAR_NAME_TRUE;
		}
		System.out.println(MESSAGE_NAME_LENGTH_CONDITION_NOT_MET);
		return VALID_CAR_NAME_FALSE;
	}

	// 자동차 대수 검증
	public static boolean isValidCarCount(String[] carNameArr) {
		if (MINIMUM_NUMBER_CAR <= carNameArr.length) {
			return true;
		}
		System.out.println(MESSAGE_REQUIRES_MORE_THAN_ONE);
		return false;
	}

	// 자동차 우승 여부 얻기
	public boolean isWinner(int raceCount) {
		return getCarMileage() == raceCount;
	}

}
