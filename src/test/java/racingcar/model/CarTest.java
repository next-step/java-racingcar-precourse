package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.enums.ErrorType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.Constants.INIT_MOVE_COUNT;

class CarTest {

    @Test
    @DisplayName("성공적으로 자동차를 생성한다")
    void makeCarSuccess() {
        String carName = "자동차생성";
        int carMove = 0;

        Car car = Car.participate(carName, carMove);

        assertEquals(car.getName(), carName);
        assertEquals(car.getMove(), carMove);
    }

    @Test
    @DisplayName("자동차 이름이 5섯글자를 넘으면 오류를 리턴한다.")
    void makeCarOverName() {
        String carName = "자동차생성실패";

        assertThatThrownBy(() -> {
            Car.participate(carName, INIT_MOVE_COUNT);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 0글자를 넘지 못하면 오류를 리턴한다.")
    void makeCarUnderName() {
        String carName = "";

        assertThatThrownBy(() -> {
            Car.participate(carName, INIT_MOVE_COUNT);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("랜덤값이 5보다 크면 move +1 한다.")
    void raceMove() {
        Car car = Car.participate("테스트", INIT_MOVE_COUNT);
        car.race(5);

        int move = car.getMove();
        assertEquals(move, 1);
    }

    @Test
    @DisplayName("랜덤값이 4보다 작으면 움직이지 않는다.")
    void raceStop() {
        Car car = Car.participate("테스트", INIT_MOVE_COUNT);
        car.race(3);

        int move = car.getMove();
        assertEquals(move, 0);
    }
}
