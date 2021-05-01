package com.github.momentjin.ui;

import com.github.momentjin.ui.application.RacingCarNamesConvertService;

import java.util.Scanner;

public class RacingCarNameInput {

    private final static String DELIMITER = ",";

    private final RacingCarNamesConvertService racingCarNamesConvertService;

    public RacingCarNameInput(RacingCarNamesConvertService racingCarNamesConvertService) {
        this.racingCarNamesConvertService = racingCarNamesConvertService;
    }

    public RacingCarNameList execute(Scanner scanner) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = scanner.nextLine().trim();

        return racingCarNamesConvertService.convert(input, DELIMITER);
    }
}
