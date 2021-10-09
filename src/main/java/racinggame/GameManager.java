/*
 * GameManager
 * java-racingcar-precourse
 *
 * Version 0.3
 *
 * Created by 강래민 on 2021-10-09.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import nextstep.utils.Console;
import racinggame.exception.IncorrectInputException;
import racinggame.service.CarService;
import racinggame.utils.Positive;

public final class GameManager {

    private static CarService carService = new CarService();
    private static Positive tryCount = new Positive(0);
    private static String input = "";

    private GameManager() {

    }

    /**
     * 유효성 검사 통과 후 게임 진행 및 종료 로직
     */
    public static void start() {
        inputCarName();
        inputTryCount();
        running();
        gameOver();
    }

    /**
     * @param input 사용자로부터 입력받은 문자열
     * @return 유효성 검사 통과 여부
     */
    private static boolean isValidateInputCarName(String input) {
        try {
            carService.inputCarNames(input);
            return false;
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    /**
     * @param input 사용자로부터 입력받은 문자열
     * @return 유효성 검사 통과 여부
     */
    private static boolean isValidateInputTryCount(String input) {
        try {
            tryCount = new Positive(input);
            return false;
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    /**
     * 사용자로부터 자동차 이름 입력
     */
    private static void inputCarName() {
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)");
            input = Console.readLine();
        } while (GameManager.isValidateInputCarName(input));
    }

    /**
     * 사용자로부터 재시도 횟수 입력
     */
    private static void inputTryCount() {
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            input = Console.readLine();
        } while (GameManager.isValidateInputTryCount(input));
    }

    /**
     * 사용자로부터 입력받은 시도 횟수를 맞춰 실행하는 로직
     */
    private static void running() {
        for (int i = 0; i < tryCount.get(); i++) {
            carService.action();
            carService.getRaceResult().print();
        }
    }

    /**
     * 최종 레이스 결과를 가지고 우승자 출력
     */
    private static void gameOver() {
        carService.getRaceResult().printWinner();
    }
}
