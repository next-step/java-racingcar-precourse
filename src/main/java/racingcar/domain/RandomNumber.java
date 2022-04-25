package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements NumberStrategy{
	private final int MIN_NUMBER = 0;
	private final int MAX_NUMBER = 9;

	@Override
	public int generate() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
