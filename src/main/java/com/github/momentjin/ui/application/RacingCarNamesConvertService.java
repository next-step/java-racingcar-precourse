package com.github.momentjin.ui.application;

import com.github.momentjin.ui.RacingCarNameList;

import java.util.ArrayList;
import java.util.List;

public class RacingCarNamesConvertService {

    public RacingCarNameList convert(String inputCarNames, String delimiter) {

        checkIsInputCarNamesEmpty(inputCarNames);
        String[] carNames = inputCarNames.split(delimiter);
        List<String> filteredCarNames = filterNotEmpty(carNames);

        return new RacingCarNameList(filteredCarNames);
    }

    private void checkIsInputCarNamesEmpty(String inputCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값을 허용하지 않습니다");
        }
    }

    private List<String> filterNotEmpty(String[] carNames) {

        List<String> filteredCarNames = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.trim().isEmpty())
                continue;

            filteredCarNames.add(carName);
        }

        return filteredCarNames;
    }
}
