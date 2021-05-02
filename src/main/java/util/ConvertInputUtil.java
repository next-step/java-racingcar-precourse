package util;

import constant.GameErrorCode;
import exception.GameException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ConvertInputUtil {
    private static final String SEPARATE_KEYWORD = ",";

    public static List<String> getCarNameFromInput(String input) {
        List<String> names = Arrays.asList(input.split(SEPARATE_KEYWORD));

        for (String name : names) {
            validateCarName(name);
        }

        checkOverlap(names);

        return names;
    }

    private static void validateCarName(String name){
        if (name.length() == 0) {
            throw new GameException(GameErrorCode.CAR_NAME_EMPTY);
        }
        if (name.length() > 5) {
            throw new GameException(GameErrorCode.CAR_NAME_SIZE_OVER);
        }
    }

    private static void checkOverlap(List<String> names) {
        Set<String> setNames = new HashSet<>(names);
        if(names.size() != setNames.size()){
            throw new GameException(GameErrorCode.CAR_NAME_OVERLAP);
        }
    }
}
