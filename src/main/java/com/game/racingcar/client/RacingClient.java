package com.game.racingcar.client;

import com.game.utils.InputUtil;

public class RacingClient implements Client {
    @Override
    public String inputCarNames() {
        printInputMessageForCarNames();
        return InputUtil.input();
    }

    private void printInputMessageForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public String inputTryCount() {
        printInputMessageForTryCount();
        return InputUtil.input();
    }

    private void printInputMessageForTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
