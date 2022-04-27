package racingcar.domain.validate;

import java.util.HashSet;
import java.util.Set;

public class ValidateNameSet {
    Set<String> validateNameSet = new HashSet<>();

    public void add(String name) {
        validateNameSet.add(name);
    }

    public int getValidateNameSetSize() {
        return validateNameSet.size();
    }
}
