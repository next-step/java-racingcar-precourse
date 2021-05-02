package racing;

class CarRecord {
	private static final String MESSAGE_FORMAT = "%s : %s";
	private static final String TRACE = "-";
	
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
	
	String toMessage() {
		String carNameVal = carName.getName();
		int positionVal = position.getVal();
		String traces = StringUtils.repeat(TRACE, positionVal);

		return String.format(MESSAGE_FORMAT, carNameVal, traces);
	}
}
