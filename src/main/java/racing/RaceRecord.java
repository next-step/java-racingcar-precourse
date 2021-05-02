package racing;

import java.util.ArrayList;
import java.util.List;

public class RaceRecord {
	private static final String RACE_RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";
	private static final String DELIMITER = ", ";

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
		StringBuilder builder = new StringBuilder();
		builder.append(RACE_RESULT_MESSAGE);
		builder.append(StringUtils.NEW_LINE);

		for (RoundRecord roundRecord : this.roundRecords) {
			builder.append(roundRecord.toMessage());
		}
		builder.append(toWinnersMessage());

		return builder.toString();
	}

	private String toWinnersMessage() {
		StringBuilder builder = new StringBuilder();
		List<String> names = new ArrayList<>();

		for (CarName carName : this.getWinners()) {
			names.add(carName.getName());
		}

		builder.append(String.format(WINNER_MESSAGE_FORMAT, String.join(DELIMITER, names)));
		builder.append(StringUtils.NEW_LINE);
		return builder.toString();
	}

	public List<RoundRecord> getRoundRecords() {
		return this.roundRecords;
	}

	private RoundRecord getLastRoundRecord() {
		int size = roundRecords.size();
		return this.roundRecords.get(size - 1);
	}
}
