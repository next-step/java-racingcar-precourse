package racinggame.racinggame;

import racinggame.circuit.FinalRecord;
import racinggame.racingcar.Movement;
import racinggame.rule.WinnerNames;

public interface Rule {
	int diceMax();

	int diceMin();

	Movement drive(int diceValue);

	WinnerNames judgeWinners(FinalRecord finalRecord);
}
