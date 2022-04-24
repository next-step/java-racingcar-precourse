package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    @DisplayName("자동차 생성 후 이름 테스트")
    @Test
    void getNamePass_P01() {
        RacingCar car = new RacingCar("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @DisplayName("자동차는 각 라운드에서 4이상일 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movePositionUpdateWhenInputFourOver_P01(int inputValue) {
        RacingCar car = new RacingCar("test");
        car.move(inputValue);
        assertThat(car.getGamePosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 각 라운드에서 4이하일 경우 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void movePositionNotUpdateWhenInputFourLess_N01(int inputValue) {
        RacingCar car = new RacingCar("test");
        car.move(inputValue);
        assertThat(car.getGamePosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 winnerPostion과 값이 같을 경우 우승자다.")
    @Test
    void isWinnerReturnTrueWhenWinnerPositionEqualGamePosition() {
        RacingCar car = new RacingCar("test", 3);
        assertThat(car.isWinner(3)).isTrue();
    }

    @DisplayName("자동차는 winnerPostion과 값이 다를경우 우승자가 아니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isWinnerReturnFalseWhenWinnerPositionNotEqualGamePosition(int currentPosition) {
        RacingCar car = new RacingCar("test", currentPosition);
        assertThat(car.isWinner(4)).isFalse();
    }

}
