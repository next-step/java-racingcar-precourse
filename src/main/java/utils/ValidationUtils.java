package utils;

import java.security.InvalidParameterException;
import java.util.List;

public class ValidationUtils {
    public static void validName(String carName) {
        if (carName.length() > 5) {
            throw new InvalidParameterException("자동차 이름은 5자 이하로 입력해 주세요.");
        }
    }

    public static void duplicateCarName(List<String> carList, List<String> compareList) {
        if (carList.size() != compareList.size()) {
            throw new InvalidParameterException("중복되는 자동차 이름이 있습니다.");
        }
    }
}
