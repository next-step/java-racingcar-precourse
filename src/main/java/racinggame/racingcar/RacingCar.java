package racinggame.racingcar;

import racinggame.ui.Rule;

public final class RacingCar {
	private final Rule rule;
	private final Dice dice;

	private final Name name;
	private Location location = new Location(0);

	public RacingCar(String name, Dice dice, Rule rule) {
		this.rule = rule;
		this.dice = dice;
		this.name = new Name(name);
	}

	public void pushPedal() {
		move(rollDice());
	}

	private int rollDice() {
		return dice.roll();
	}

	private void move(int diceValue) {
		Racing next = rule.drive(diceValue);
		if(next == Racing.FORWARD){
			location.forward();
		}
	}

	public LapRecord record() {
		return new LapRecord(name, location);
	}
}
