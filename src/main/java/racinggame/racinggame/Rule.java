package racinggame.racinggame;

import racinggame.circuit.FinalRecord;
import racinggame.racingcar.Movement;
import racinggame.rule.WinnerNames;

public interface Rule {

	Movement judgeMovement(int diceValue);

	WinnerNames judgeWinners(FinalRecord finalRecord);

}
