package racingcar.utils;

import racingcar.view.OutputView;

import java.util.List;


public class ValidationUtils {

    private static boolean isValidCarName;
    private static boolean isValidRoundNum;

    public ValidationUtils(List<String> carNames) {
        validCarNames(carNames);
    }

    public ValidationUtils(String roundNum) {
        isValidRoundNum = true;
        if(!validRoundNum(roundNum)) {
            isValidRoundNum = false;
        }
    }

    public static void validCarNames(List<String> carNames) {

        boolean isValid = true;

        for (String carName : carNames) {
            isValid &= validCarName(carName);
        }

        isValidCarName = isValid;
    }

    public static boolean validCarName(String carName) {

        if(carName.length()>5) {
            OutputView.printErrorMsg("자동차 이름은 5자 이하만 가능합니다.");
            return false;
        }

        if(carName.trim().length()<1) {
            OutputView.printErrorMsg("자동차 이름은 최소 1자 이상이여야 합니다.");
            return false;
        }

        return true;
    }

    public static boolean validRoundNum(String roundNum) {

        if(!isStringInt(roundNum)){
            OutputView.printErrorMsg("시도 횟수는 숫자여야 합니다.");
            return false;
        }

        if(Integer.parseInt(roundNum)<1) {
            OutputView.printErrorMsg("시도 횟수는 최소 1 이상이여야 합니다.");
            return false;
        }

        return true;
    }

    private static boolean isStringInt(String roundNum) {
        try {
//            Double.parseDouble(roundNum);
            Integer.parseInt(roundNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidCarName() {
        return isValidCarName;
    }

    public boolean isValidRoundNum() {
        return isValidRoundNum;
    }


}
