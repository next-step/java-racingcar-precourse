package racing;

import java.util.ArrayList;
import java.util.List;

public class RaceRecord {
	private List<RoundRecord> roundRecords;

	RaceRecord(List<RoundRecord> roundRecords) {
		this.roundRecords = roundRecords;
	}

	public List<CarName> getWinners() {
		RoundRecord lastRoundRecord = getLastRoundRecord();
		List<CarRecord> lastRoundCarRecords = lastRoundRecord.getCarRecords();
		Position maxPosition = getMaxPosition(lastRoundCarRecords);

		List<CarName> winners = new ArrayList<>();
		for (CarRecord carRecord : lastRoundCarRecords) {
			addCarNameIfPositionEqual(carRecord, maxPosition, winners);
		}

		return winners;
	}

	private void addCarNameIfPositionEqual(
		CarRecord carRecord,
		Position targetPosition,
		List<CarName> carNames
	) {
		CarName carName = carRecord.getCarName();
		Position position = carRecord.getPosition();

		if (targetPosition.equals(position)) {
			carNames.add(carName);
		}
	}

	private Position getMaxPosition(List<CarRecord> carRecords) {
		int maxVal = 0;

		for (CarRecord carRecord : carRecords) {
			Position position = carRecord.getPosition();
			maxVal = Math.max(maxVal, position.getVal());
		}

		return new Position(maxVal);
	}

	String toMessage() {
		return null;
	}

	public List<RoundRecord> getRoundRecords() {
		return this.roundRecords;
	}

	private RoundRecord getLastRoundRecord() {
		int size = roundRecords.size();
		return this.roundRecords.get(size - 1);
	}
}
