package car;

public class Car {
	public static final int NAME_LENGTH_MAX = 5;
	public static final int FORWARD_CONDITION = 4;

	private final String name;
	private CarIndex carIndex;

	public Car(String name) {
		if (name.length() > NAME_LENGTH_MAX) {
			throw new IllegalArgumentException("자동차 이름은 " + NAME_LENGTH_MAX + "자 이하만 가능하다.");
		}
		carIndex = new CarIndex();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public CarStatus move(int movePoint) {
		if (movePoint >= FORWARD_CONDITION) {
			return CarStatus.FORWARD;
		}
		return CarStatus.STOP;
	}

	public CarIndex getCarIndex() {
		return carIndex;
	}

	public void updateMoveIndex(CarStatus carStatus) {
		this.carIndex.addIndex(carStatus);
	}
}
