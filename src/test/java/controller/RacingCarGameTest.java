package controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    private RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    @DisplayName("이름이 5자 넘는 경우 테스트")
    void checkNameLength_이름이_5자_초과() {
        // given
        String name = "abcdef";
        // when
        boolean actual = racingCarGame.checkNameLength(name);
        // then
        assertEquals(false, actual);
    }

    @Test
    @DisplayName("이름이 5자 이하로 알맞게 들어온 경우 테스트")
    void checkNameLength_이름이_5자_이하() {
        // given
        String name = "abcd";
        // when
        boolean actual = racingCarGame.checkNameLength(name);
        // then
        assertEquals(true, actual);
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinner() {
        // given
        ArrayList<Car> cars = new ArrayList<>();
        Car winner = new Car("winner");
        winner.setDistance(2);
        cars.add(winner);
        Car loser = new Car("loser");
        loser.setDistance(1);
        cars.add(loser);
        //when
        racingCarGame.findWinner(cars);
        //then
        assertEquals(true, winner.isWinner());
        assertEquals(false, loser.isWinner());
    }
}