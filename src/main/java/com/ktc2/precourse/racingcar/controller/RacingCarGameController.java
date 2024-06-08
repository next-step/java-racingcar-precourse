package com.ktc2.precourse.racingcar.controller;

import com.ktc2.precourse.racingcar.model.*;
import com.ktc2.precourse.racingcar.view.*;
import java.util.List;

/**
 * 자동차 경주 게임의 전체적인 로직을 표현하는 controller
 */
public class RacingCarGameController {

    private final static AcceptView<DtoRacingCarList> racingCarList;
    private final static AcceptView<DtoAttemptsNumber> positiveInteger;
    private final static DisplayView<String> message;
    private final static DisplayView<List<RacingCar>> ingame;
    private final static DisplayView<List<RacingCar>> result;

    static {
        positiveInteger = new AcceptAttemptsNumberView();
        racingCarList = new AcceptRacingCarListView();
        message = new DisplayMessageView();
        ingame = new DisplayIngameView();
        result = new DisplayGameResultView();
    }

    /**
     * 초간단 자동차 경주 게임을 플레이한다.
     */
    public static void play() {
        //AcceptView로부터 데이터를 받아온다.
        List<RacingCar> cars = racingCarList.getDto().racingCarList();
        int attempts = positiveInteger.getDto().attempts();

        //경주를 시작한다.
        message.display("경주 시작!\n");

        //주어진 시도동안 각 자동차는 앞으로 가기를 시도한다.
        for (int i = 0; i < attempts; i++) {
            message.display("[" + (i + 1) + "번째 시도]");
            cars.replaceAll(RacingCar::tryMoveForward);
            ingame.display(cars);
        }

        //게임 결과를 출력한다.
        result.display(cars);
    }
}
