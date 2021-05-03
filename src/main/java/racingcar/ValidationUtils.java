package racingcar;

import java.util.Arrays;
import java.util.List;

public class ValidationUtils {
    public static boolean validName(String carName) {
        if(carName.length() > 5){
            return false;
        }
        return true;
    }

    public static List<String> stringToList(String carNames) {
        List<String> listCar = Arrays.asList(carNames.split(","));
         return listCar;
    }
}
