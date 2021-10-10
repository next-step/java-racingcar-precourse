package racinggame.domain;

public class Race {

	private final LineUp lineUp;

	private final Integer tryNumber;

	public Race(LineUp lineUp, Integer tryNumber) {
		this.lineUp = lineUp;
		this.tryNumber = tryNumber;
	}

	public void drive() {
		for (int i = 0; i < tryNumber; i++) {
			lineUp.drive();
		}

		award(lineUp.getRecord());
	}

	private void award(Record record) {
		String winners = record.awardTo();
		System.out.println("최종 우승자는 "+ winners +" 입니다.");
	}
}
