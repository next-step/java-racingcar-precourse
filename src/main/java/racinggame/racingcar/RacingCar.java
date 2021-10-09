package racinggame.racingcar;

import racinggame.ui.Rule;

public final class RacingCar {
	private final Rule rule;
	private final Dice dice;

	private final Name name;
	private int location = 0;

	public RacingCar(Rule rule, String name) {
		this.rule = rule;
		this.dice = new Dice(rule.diceMin(), rule.diceMax());
		this.name = new Name(name);
	}

	public void nextBehavior() {;
		move(rollDice());
	}

	private int rollDice() {
		return dice.roll();
	}

	private void move(int diceValue) {
		Racing next = rule.drive(diceValue);
		location += next.movable();
	}

	public String getName() {
		return name.valueOf();
	}

	public int currentLocation() {
		return location;
	}
}
