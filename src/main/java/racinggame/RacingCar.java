package racinggame;

public class RacingCar {
	private final int MIN_NAME_LENGTH = 0;
	private final int MAX_NAME_LENGTH = 5;
	private final int MIN_GO_NUMBER = 4;

	private String name;
	private int position = 0;

	public RacingCar(String recingCarName) {
		name = recingCarName;
	}

	public boolean checkCarNameLength() {
		int nameLength = getNameLength();
		return nameLength > MIN_NAME_LENGTH && nameLength <= MAX_NAME_LENGTH;
	}

	int getNameLength() {
		return name.length();
	}

	public RacingStatus getRacingResult(int racingNumber) {
		if(racingNumber < MIN_GO_NUMBER) {
			return RacingStatus.STOP;
		}

		return RacingStatus.GO;
	}

	public void moveCar(int racingNumber) {
		if(getRacingResult(racingNumber).isGo()) {
			position += 1;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public String convertPositionToString() {
		String moveString = "";

		for(int i = 0; i < position; i++) {
			moveString += "-";
		}

		return moveString;
	}
}
