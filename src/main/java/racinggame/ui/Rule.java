package racinggame.ui;

import racinggame.racingcar.Racing;

public interface Rule {
	void validateNames(String names);

	int diceMax ();

	int diceMin ();

	Racing drive (int diceValue);
}
