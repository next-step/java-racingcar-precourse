package racinggame.common;

import racinggame.ui.Rule;

public class RacingCar {
	private final Rule rule;
	private final Name name;

	public RacingCar(Rule rule, String name) {
		this.rule = rule;
		this.name = new Name(name);
	}
}
