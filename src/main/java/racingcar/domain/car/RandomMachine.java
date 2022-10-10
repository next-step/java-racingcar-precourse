package racingcar.domain.car;

import static racingcar.constant.SETTING.*;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomMachine {

	int startRange;
	int endRange;

	public RandomMachine(int startRange, int endRange) {
		this.startRange = startRange;
		this.endRange = endRange;
	}

	public int goAndStop() {
		Integer number = Randoms.pickNumberInRange(startRange,endRange);
		if(isGo(number)){
			return GO;
		}
		return STOP;
	}

	private boolean isGo(Integer number) {
		return number >= GO_NO;
	}

}
