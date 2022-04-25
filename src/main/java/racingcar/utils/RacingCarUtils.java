package racingcar.utils;

import racingcar.view.RacingCarOutputView;

public class RacingCarUtils {

    private static int ZERO = 0;

    private static String SPLIT_CODE = ",";

    public static String[] splitName(String sNames) {
        if(isCheckSplit(sNames))
            return sNames.split(SPLIT_CODE);
        return new String[]{sNames};
    }

    private static boolean isCheckSplit(String sNames) {
        return sNames.contains(SPLIT_CODE);
    }

    public static int roundNumber(String sNumber) {
        if(isCheckNumberFormat(sNumber)) {
            return Integer.parseInt(sNumber);
        }
        return 0;
    }

    private static boolean isCheckNumberFormat(String sNumber) {
        try {
            if(Integer.parseInt(sNumber) <= ZERO) {
                RacingCarOutputView.errorNumberFormat();
                return false;
            }
        } catch (Exception e) {
            RacingCarOutputView.errorNumberFormat();
            return false;
        }
        return true;
    }
}
