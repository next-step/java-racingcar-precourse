package utils;

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
        List<String> carList = Arrays.asList(carNames.split(","));
         return carList;
    }

    // TODO 더 좋은 방법으로 다시 짜기
    public static boolean duplicateName(List<String> carList) {
        int count = 0;

        for(String car : carList){
            if(carList.contains(car)){
                count++;
            }
        }

        if(count > 1){
            return true;
        }

        return false;
    }
}
