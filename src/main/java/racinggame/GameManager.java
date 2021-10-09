/*
 * GameManager
 * java-racingcar-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 2021-10-09.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import racinggame.exception.IncorrectInputException;
import racinggame.service.CarService;
import racinggame.utils.Positive;

public final class GameManager {

    private static CarService carService = new CarService();
    private static Positive tryCount = new Positive(0);

    private GameManager() {

    }

    /**
     * @param input 사용자로부터 입력받은 문자열
     * @return 유효성 검사 통과 여부
     */
    public static boolean isValidateInputCarName(String input) {
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
    public static boolean isValidateInputTryCount(String input) {
        try {
            tryCount = new Positive(input);
            return false;
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    /**
     * 유효성 검사 통과 후 게임 진행 및 종료 로직
     */
    public static void start() {
        running();
        gameOver();
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
