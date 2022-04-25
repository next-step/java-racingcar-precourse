package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumUtils {

    public int generateRandomNum(){
        return Randoms.pickNumberInRange(ValidNumberConditionEnum.MIN_VALUE.getValue(), ValidNumberConditionEnum.MAX_VALUE.getValue());
    }
}
