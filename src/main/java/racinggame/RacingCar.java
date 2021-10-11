package racinggame;

import nextstep.utils.Randoms;

public class RacingCar {

	private final String name;
	private Position position;

	public RacingCar(String name) {
		this.name = name;
		this.position = new Position(0);
	}

	public Position move() {
		Movement movement = new Movement(Randoms.pickNumberInRange(0, 9));
		if (movement.isMoved()) {
			this.position = new Position(this.position.getX() + 1);
		}
		return this.position;
	}

	public Position moves(int num) {
		for (int i = 0; i < num; i++) {
			move();
		}
		return this.position;
	}
}
