package racing;

import java.util.List;

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
			builder.append("\n");
		}
		builder.append("\n");

		return builder.toString();
	}
}
