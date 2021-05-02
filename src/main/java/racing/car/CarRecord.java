package racing.car;

import racing.car.position.Position;
import racing.utils.StringUtils;

public class CarRecord {
	private static final String MESSAGE_FORMAT = "%s : %s";
	private static final String TRACE = "-";
	
	private CarName carName;
	private Position position;

	private CarRecord(CarName carName, Position position) {
		this.carName = carName;
		this.position = position;
	}

	public static CarRecord from(Car car) {
		CarName carName = new CarName(car.getCarName().getName());
		Position position = new Position(car.getPosition().getVal());

		return new CarRecord(carName, position);
	}

	public CarName getCarName() {
		return carName;
	}

	public Position getPosition() {
		return position;
	}
	
	public String toMessage() {
		String carNameVal = carName.getName();
		int positionVal = position.getVal();
		String traces = StringUtils.repeat(TRACE, positionVal);

		return String.format(MESSAGE_FORMAT, carNameVal, traces);
	}
}
