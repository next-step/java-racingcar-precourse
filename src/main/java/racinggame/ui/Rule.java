package racinggame.ui;

import racinggame.circuit.FinalRecord;
import racinggame.racingcar.Racing;
import racinggame.rule.WinnerNames;

public interface Rule {
	int diceMax();

	int diceMin();

	Racing drive(int diceValue);

	WinnerNames judgeWinners(FinalRecord finalRecord);
}
