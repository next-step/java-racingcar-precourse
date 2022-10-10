package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RacingCarNum;

public class RacingCarRandom {

	private int randomNum;

	public RacingCarRandom() {
		this.randomNum = getRandomNumber();
	}

	public int getRandomNum() {
		return this.randomNum;
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(RacingCarNum.MIN_RANDOM_NUM, RacingCarNum.MAX_RANDOM_NUM);
	}

}
