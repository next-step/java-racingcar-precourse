package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCars;
import racingcar.util.ValidationUtils;
import racingcar.view.RacingCarView;

public class RacingCarController {
    public static final String INPUT_SPLIT_SEPARATOR = ",";
    private static String racingCarNamesInput;
    private static String playCount;

    public static void intro() {
        // 경주할 자동차 이름(쉼표 기준으로 구분)
        RacingCarView.printRacingCarNamePhrase();
        introNameCheck();

        // 시도할 회수 입력
        RacingCarView.printPlayCountPhrase();
        introNumberCheck();

        play();
    }

    private static void introNameCheck() {
        boolean nameCheck = false;
        while (!nameCheck) {
            nameCheck = inputNameCheck();
        }
    }

    private static void introNumberCheck() {
        boolean numberCheck = false;
        while (!numberCheck) {
            numberCheck = inputNumberCheck();
        }
    }

    private static boolean inputNameCheck() {
        try {
            racingCarNamesInput = Console.readLine();
            return ValidationUtils.validNames(racingCarNamesInput);
        } catch (IllegalArgumentException e) {
            RacingCarView.printNameError();
        }
        return false;
    }

    private static boolean inputNumberCheck() {
        try {
            playCount = Console.readLine();
            return ValidationUtils.validNo(Integer.parseInt(playCount));
        } catch (IllegalArgumentException e) {
            RacingCarView.printNumberError();
        }
        return false;
    }

    public static void play() {
        // 자동차 이름 쉼표기준으로 구분
        String[] racingCarNames = racingCarNamesInput.split(INPUT_SPLIT_SEPARATOR);
        // 자동차 생성
        RacingCars racingCars = RacingCars.fromNames(racingCarNames);

        // 각 자동차 이동 횟수에 맞게 이동 처리
        RacingCarView.printPlayResult();

        for (int i = 0; i < Integer.parseInt(playCount); i++) {
            racingCars.move();
            RacingCarView.printPosition(racingCars.getRacingCarList());
        }

        // 최종 우승자 출력
        RacingCarView.printWinner(racingCars.getWinner());
    }

}
