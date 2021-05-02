package com.game.racingcar;

import com.game.racingcar.client.Client;
import com.game.racingcar.client.RacingClient;
import com.game.runner.Game;

public class RacingCarGame implements Game {
    private boolean playingYn = true;
    private static Client client;

    public RacingCarGame() {
        client = new RacingClient();
    }

    @Override
    public void start() {
        System.out.println(">> 자동차 경주 게임을 시작하겠습니다.");
        init();
    }

    private void init() {
        String inputCarNames = client.inputCarNames();
        String inputTryCount = client.inputTryCount();
    }

    @Override
    public boolean isPlaying() {
        return playingYn;
    }

    @Override
    public void run() {

    }

    @Override
    public void exit() {
        playingYn = false;
    }

    @Override
    public void end() {
        System.out.println(">> 자동차 경주 게임을 종료하겠습니다.");
    }
}
