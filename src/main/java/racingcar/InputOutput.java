package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputOutput {
    public static List<String> separateName(String input) {
        List<String> carNameList = new ArrayList<>();
        carNameList.addAll(Arrays.asList(input.split(",")));

        return carNameList;
    }

    public static boolean checkLen(String carName) {
        if(carName.length() <= 5) {
            return true;
        }
        return false;
    }
}
