package racinggame.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    public void before() {
        racingGame = new RacingGame("pobi,crong,honux", 4);
    }

    @Test
    void 자동차_이동_랜덤_숫자() {
        int randomNumber = RacingGame.getRandomNumber();
        assertThat(randomNumber).isNotZero();
        assertThat(randomNumber).isLessThan(10);
        assertThat(randomNumber).isGreaterThan(0);
    }

    @Test
    void 자동차_배열_이름_테스트() {
        assertThat(RacingGame.isAvailableCarNames("pobi,crong,maxmax")).isFalse();
        assertThat(RacingGame.isAvailableCarNames("pobi,crong,honux")).isTrue();
    }

    @DisplayName("레이싱 게임 객체 생성 후 car list 확인")
    @Test
    void check_car_list() {
        assertThat(racingGame.getParticipationCarList().size()).isEqualTo(3);
        assertThat(racingGame.getParticipationCarList().size()).isNotEqualTo(4);
    }


}