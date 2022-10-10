package racingcar.domain.car;

import static racingcar.constant.ERROR.*;
import static racingcar.constant.SETTING.*;

import racingcar.constant.ERROR;

public class Round {
	int round;

	public Round (int round){
		this.round = round;
		lengthCheck();
	}

	public static Round of(Integer count) {
		return new Round(count);
	}

	public static Round of(String count) {
		boolean isNotNumber = !count.chars().allMatch( Character::isDigit );
		if(isNotNumber){
			throw new IllegalArgumentException(COUNT_TYPE_ERROR);
		}
		return new Round(Integer.parseInt(count));
	}

	private void lengthCheck() {
		if(round <MIN_ROUND|| round >MAX_ROUND){
			throw new IllegalArgumentException(ERROR.COUNT_MISS);
		}
	}

	public int getRound() {
		return round;
	}
}
