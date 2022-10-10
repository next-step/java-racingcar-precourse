package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.AccelValue;

/**
 * @author garden.iee
 */
public class AccelGenerator {
	public static AccelValue generate() {
		return AccelValue.of(Randoms.pickNumberInRange(AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE));
	}
}