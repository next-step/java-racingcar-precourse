package racingcar.common;

import static racingcar.common.Constants.CAR_SPLIT_WORD;

public class SplitUtil {

    public static String[] carSplit(String carName) {
        return carName.split(CAR_SPLIT_WORD);
    }
}
