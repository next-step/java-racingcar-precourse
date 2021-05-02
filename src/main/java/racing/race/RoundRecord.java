package racing.race;

import java.util.List;

import racing.car.CarRecord;
import racing.utils.StringUtils;

public class RoundRecord {
	private List<CarRecord> carRecords;

	RoundRecord(List<CarRecord> carRecords) {
		this.carRecords = carRecords;
	}

	List<CarRecord> getCarRecords() {
		return carRecords;
	}

	String toMessage() {
		StringBuilder builder = new StringBuilder();

		for (CarRecord carRecord : carRecords) {
			builder.append(carRecord.toMessage());
			builder.append(StringUtils.NEW_LINE);
		}
		builder.append(StringUtils.NEW_LINE);

		return builder.toString();
	}
}
