package nextstep.move;

import nextstep.generator.NumberGenerator;

public abstract class MovingStrategy {

	private static final int MIN_REQUIREMENT_FOR_MOVEMENT = 4;

	private final NumberGenerator numberGenerator;

	protected MovingStrategy(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public MoveStatus move() {
		if (numberGenerator.generate() >= MIN_REQUIREMENT_FOR_MOVEMENT) {
			return MoveStatus.MOVE;
		}

		return MoveStatus.STOP;
	}
}
