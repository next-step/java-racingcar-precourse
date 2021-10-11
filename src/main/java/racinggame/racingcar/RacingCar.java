package racinggame.racingcar;

import java.util.Objects;

import racinggame.ui.Rule;

public final class RacingCar {
	private final Rule rule;
	private final Dice dice;

	private final Name name;
	private int location = 0;

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
		location += next.movable();
	}

	public LapRecord record() {
		return new LapRecord(name, location);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCar racingCar = (RacingCar)o;
		return location == racingCar.location && rule.equals(racingCar.rule) && dice.equals(racingCar.dice)
			&& name.equals(
			racingCar.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rule, dice, name, location);
	}
}
