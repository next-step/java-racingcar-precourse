public class Car {
	public static final int NAME_LENGTH_MAX = 5;

	private final String name;
	private MovePosition movePosition;

	public Car(String name) {
		if (name.length() > NAME_LENGTH_MAX) {
			throw new IllegalArgumentException("자동차 이름은 " + NAME_LENGTH_MAX + "자 이하만 가능하다.");
		}
		this.name = name;
		movePosition = new MovePosition();
	}

	public String getName() {
		return this.name;
	}

	public CarStatus move(int movePoint) {
		if (movePoint >= MovePosition.FORWARD_CONDITION) {
			movePosition.addForwardPoint();
			return CarStatus.FORWARD;
		}
		return CarStatus.STOP;
	}

	public int getMovePoint() {
		return this.movePosition.getPoint();
	}
}
