package racinggame.racingcar;

import racinggame.common.RacingCarName;
import racinggame.racinggame.Rule;

public final class RacingCar {
	private final Rule rule;
	private final Dice dice;
	private final RacingCarName racingCarName;

	private Location location = new Location(0);

	public RacingCar(RacingCarName racingCarName, Dice dice, Rule rule) {
		this.rule = rule;
		this.dice = dice;
		this.racingCarName = racingCarName;
	}

	/**
	 * 주사위를 던져 움직임을 결정한다.
	 *
	 * @return {@link LapRecord}
	 */
	public LapRecord pushPedal() {
		Location location = move(rollDice());

		return new LapRecord(racingCarName, location);
	}

	private int rollDice() {
		return dice.roll();
	}

	private Location move(int diceValue) {
		Racing next = rule.drive(diceValue);

		if (next == Racing.FORWARD) {
			this.location = location.forward();
		}

		return new Location(location.valueOf());
	}
}
