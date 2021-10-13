package racinggame.circuit;

import racinggame.racingcar.Movement;

public interface MovementRule {
	Movement judgeMovement(int diceValue);
}
