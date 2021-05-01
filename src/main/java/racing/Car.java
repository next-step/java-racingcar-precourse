package racing;

public class Car {
	private static final int INITIAL_POSITION = 0;

	private CarName carName;
	private Position position;
	private Engine engine;

	public Car(CarName carName) {
		this.carName = carName;
		this.position = new Position(INITIAL_POSITION);
		this.engine = new Engine();
	}

	public void drive() {
		Power power = this.engine.getPower();
		CarStatus carStatus = this.engine.run(power);

		if (carStatus.isForward()) {
			forward();
		}

		if (carStatus.isStop()) {
			stop();
		}
	}

	public void forward() {
		this.position = new Position(this.position.getVal() + 1);
	}

	public void stop() {
		this.position = new Position(this.position.getVal());
	}

	public CarName getCarName() {
		return this.carName;
	}

	public Position getPosition() {
		return this.position;
	}
}
