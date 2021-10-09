package racinggame.domain;

import nextstep.utils.Randoms;

public class CarMove {
	public static final int MIN = 0;
	public static final int MAX = 9;
	public static final int MORE_THAN_GO = 4;
	public static final String ERROR_MESSAGE =
		"[ERROR] CarMove 는 " + MIN + "~" + MAX + "사이의 값만 가질 수 있습니다.";

	private int carMove;

	public CarMove(int carMove) {
		validateCarMove(carMove);
		this.carMove = carMove;
	}

	public boolean isGo() {
		return carMove >= MORE_THAN_GO;
	}

	public void move() {
		carMove = Randoms.pickNumberInRange(MIN, MAX);
	}

	private void validateCarMove(int carMove) {
		if (carMove < MIN || carMove > MAX) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

}
