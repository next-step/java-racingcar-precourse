package racingcar.input.validator.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.ExceptionType;
import racingcar.input.validator.InputValidator;
import racingcar.utils.WordUtils;

public class CarNamesOverlapValidator implements InputValidator {
    @Override
    public void validate(String input) {
        List<String> carNames = Arrays.asList(input.split(WordUtils.COMMA));
        carNames.replaceAll(String::trim);

        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNames.size() != carNameSet.size()) {
            throw new IllegalArgumentException(ExceptionType.NOT_CONTAINS_CAR_NAMES_OVERLAP.getMessage());
        }
    }
}
