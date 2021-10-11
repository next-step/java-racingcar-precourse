package racinggame.ui;

import racinggame.circuit.FinalRecord;
import racinggame.racingcar.Racing;

public interface Rule {
	void validateNames(String names);

	int diceMax();

	int diceMin();

	Racing drive(int diceValue);

	String judgeWinners(FinalRecord finalRecord);
}
