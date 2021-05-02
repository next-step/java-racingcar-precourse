package com.game.racingCar;

import com.game.GameApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class RacingCarGameTest {

    class HackingRacingCarGame extends RacingCarGame {
        @Override
        public void prepare() {
            scanner = new Scanner(System.in);
            tryCount = 10;
            playCount = 0;
            racingControlTower = new RacingControlTower("pobi,jun,rulla");
        }
    }


    @DisplayName("자동차 경주 게임 테스트")
    @Test
    public void playRacingCarGameTest() {
        // Given
        // When & Then
        GameApplication gameApplication = new GameApplication(new HackingRacingCarGame());
        gameApplication.run();
    }

}
