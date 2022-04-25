package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.CustomIllegalArgumentException;
import racingcar.model.CarStatus;

public class GameUtils {
	public static final int MIN_NO = 0;
	public static final int MID_NO = 4;
	public static final int MAX_NO = 9;
	
	public static int strToint(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new CustomIllegalArgumentException("-2,147,483,648에서 2,147,483,647범위의 숫자만 가능합니다.");
		}
	}
	
	public static CarStatus getCarStatus(int pickNumber) {
		validatePickNumber(pickNumber);
		if(pickNumber < MID_NO) {
			return CarStatus.STOP;
		}
		return CarStatus.GO;
	}

	public static int pickNumberInRange(){
		return Randoms.pickNumberInRange(MIN_NO, MAX_NO);
	}
	
	public static void validatePickNumber(int pickNumber) {
		if(pickNumber<MIN_NO || pickNumber>MAX_NO) {
			throw new CustomIllegalArgumentException(MIN_NO+"부터 "+MAX_NO+"까지 숫자만 입력이 가능합니다.");
		}
	}
	
}
