package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerateService {
    private static final Integer MAX_NUMBER_RANGE = 9;
    private static final Integer MIN_NUMBER_RANGE = 0;

    public static Integer generateRandomInteger(){
        Integer result = -1;
        result = Randoms.pickNumberInRange(MIN_NUMBER_RANGE,MAX_NUMBER_RANGE) ;
        return result;
    }
}
