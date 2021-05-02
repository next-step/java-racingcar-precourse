package racing;

class CarRecord {
	private CarName carName;
	private Position position;

	private CarRecord(CarName carName, Position position) {
		this.carName = carName;
		this.position = position;
	}

	static CarRecord from(Car car) {
		CarName carName = new CarName(car.getCarName().getName());
		Position position = new Position(car.getPosition().getVal());

		return new CarRecord(carName, position);
	}

	CarName getCarName() {
		return carName;
	}

	Position getPosition() {
		return position;
	}
}
