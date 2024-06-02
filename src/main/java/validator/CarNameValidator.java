package validator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import static validator.ErrorMessages.*;
import static race.Parameters.*;

public class CarNameValidator {

    /**
     * 자동차의 이름을 검증한다.
     * @param carNames : 자동차들의 이름
     * @throws IllegalArgumentException
     * 중복된 이름이 있거나 길이가 0이거나 6이상인 이름이 있을 때
     */
    public void test(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() < NAME_MIN_LENGTH) {
                throw new IllegalArgumentException(NAME_TOO_SHORT);
            }
            if (carName.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(NAME_TOO_LONG);
            }
        }

        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() < carNames.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATED);
        }
    }
}
