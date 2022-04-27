package racingcar.domain.validate;

import java.util.ArrayList;
import java.util.List;

public class ValidateNameList {
    List<String> validateNameList = new ArrayList<>();

    public int getValidateNameListSize() {
        return validateNameList.size();
    }

    public void add(String name) {
        validateNameList.add(name);
    }
}
