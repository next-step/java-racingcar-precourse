package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        this.car = new Car("ssam");
    }

    @Test
    @DisplayName("우승 포지션값이 3이고 조회차량의 포지션값이 3이라면 true 를 반환한다.")
    void winnerPosition() {
        car = new Car("ssam", 3);
        assertThat(car.isWinnerPosition(3)).isTrue();
    }

    @Test
    @DisplayName("우승 포지션값이 3이고 조회차량의 포지션값이 2라면 false 를 반환한다.")
    void losePosition() {
        car = new Car("ssam", 2);
        assertThat(car.isWinnerPosition(3)).isFalse();
    }

}
