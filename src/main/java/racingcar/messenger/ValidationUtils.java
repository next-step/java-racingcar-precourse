package racingcar.messenger;

import java.util.List;

public class ValidationUtils {

    public static void validateNameLength(List<String> carList) {
        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateMoveNum(String moveNum) {
        if (!isInteger(moveNum)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isInteger(String input) {
        if(input.equals("")){
            //문자열이 공백인지 확인
            return false;
        }
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public static int validateGo(int randomNum) {
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }

}
