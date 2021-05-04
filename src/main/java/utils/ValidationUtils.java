package utils;

import java.util.Arrays;
import java.util.List;

public class ValidationUtils {
    public static boolean validName(String carName) {
        return carName.length() <= 5;
    }

    // TODO 더 좋은 방법으로 다시 짜기
    public static boolean duplicateName(List<String> carList) {
        int count = 0;

        for (String car : carList) {
            if (carList.contains(car)) {
                count++;
            }
        }

        return count > 1;
    }
}
