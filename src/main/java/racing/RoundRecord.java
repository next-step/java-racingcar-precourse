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
}
