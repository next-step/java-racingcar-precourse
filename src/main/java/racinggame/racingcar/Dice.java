package racinggame.racingcar;

import nextstep.utils.Randoms;

public final class Dice {
	private final int min;
	private final int max;

	public Dice (int min, int max){
		this.min = min;
		this.max = max;
	}

	public int roll (){
		return Randoms.pickNumberInRange(min, max);
	}
}
