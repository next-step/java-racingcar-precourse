package racinggame.domain;

public class Race {

	private final LineUp lineUp;

	private final Integer tryNumber;

	private final Message message = new Message();

	public Race(LineUp lineUp, Integer tryNumber) {
		this.lineUp = lineUp;
		this.tryNumber = tryNumber;
	}

	public void drive() {
		message.startDrive();
		for (int i = 0; i < tryNumber; i++) {
			lineUp.drive();
			message.lineBreak();
		}

		award(lineUp.getRecord());
	}

	private void award(Record record) {
		String winners = record.awardTo();
		message.printWinner(winners);
	}
}
