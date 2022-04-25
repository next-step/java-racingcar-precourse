package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.rule.CarMoveRule;

public class RacingCarTest {
    CarMoveRule carMoveRule;

    @BeforeEach
    @Test
    void set() {
        carMoveRule = new CarMoveRule(1, 0, 4, "-");
    }

    @DisplayName("자동차 생성 후 이름 테스트")
    @Test
    void getNamePass_P01() {
        RacingCar car = new RacingCar("test", carMoveRule);
        assertThat(car.getName().getName()).isEqualTo(new CarName("test").getName());
    }

    @DisplayName("자동차는 각 라운드에서 4이상일 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movePositionUpdateWhenInputFourOver_P01(int inputValue) {
        RacingCar car = new RacingCar("test", carMoveRule);
        car.move(inputValue);
        assertThat(car.getGamePosition().getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 각 라운드에서 4이하일 경우 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void movePositionNotUpdateWhenInputFourLess_N01(int inputValue) {
        RacingCar car = new RacingCar("test", carMoveRule);
        car.move(inputValue);
        assertThat(car.getGamePosition().getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 winnerPostion과 값이 같을 경우 우승자다.")
    @Test
    void isWinnerReturnTrueWhenWinnerPositionEqualGamePosition() {
        RacingCar car = new RacingCar("test", 3, carMoveRule);
        assertThat(car.isWinner(new Position(3))).isTrue();
    }

    @DisplayName("자동차는 winnerPostion과 값이 다를경우 우승자가 아니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isWinnerReturnFalseWhenWinnerPositionNotEqualGamePosition(int currentPosition) {
        RacingCar car = new RacingCar("test", currentPosition, carMoveRule);
        assertThat(car.isWinner(new Position(4))).isFalse();
    }

    @DisplayName("자동차는 현재상태 결과가 예상한 문자열과 같아야 한다")
    @ParameterizedTest
    @CsvSource(value = {"3^test : ---", "1^test : -",}, delimiter = '^')
    void getPrintCurrentResultEqualExpected(String position, String expected) {
        RacingCar car = new RacingCar("test", Integer.parseInt(position), carMoveRule);
        assertThat(car.getPrintCurrentResult()).isEqualTo(expected);
    }
}
