package racinggame.util;

import java.util.List;

import racinggame.code.CarConfig;
import racinggame.code.ErrorMessage;
import racinggame.exception.RacinggameException;

public class ArrayUtils {
    public static void validateArraySize(List<String> inputList) {
        if (inputList.size() < CarConfig.CAR_LIST_MIN_SIZE.getValue()) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_LIST_SIZE.getValue());
        }
    }
}
