package racingcar.constant;

import static racingcar.constant.SETTING.*;

public class ERROR {
	public static final String EXCESS_LENGTH = "자동차의 이름은 5자리 이상 입력 할 수 없습니다.";
	public static final String EMPTY_NAME = "자동차의 이름은 빈값을 입력 할 수 없습니다" ;
	public static final String COUNT_MISS = String.format("횟수는 %d이상 %d이하만 가능합니다.",MIN_ROUND,MAX_ROUND);
}
