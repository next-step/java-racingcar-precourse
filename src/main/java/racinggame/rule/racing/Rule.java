package racinggame.rule.racing;

import racinggame.racingcar.Movement;

public interface Rule {
	Movement judgeMovement(int diceValue);
}
