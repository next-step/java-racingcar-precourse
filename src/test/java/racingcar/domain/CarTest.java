package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

/**
 * CarTest
 *
 * @author suji
 * @date 2022-04-23
 **/
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 자동차_생성(String name) {
        //given & when
        Car car = Car.newInstance(name);

        //then
        assertThat(car.getCarName()).isEqualTo(name);
        assertThat(car.getMovementCount()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_공백_예외처리() {
        //given
        String name = " ";

        //when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.newInstance(name))
                .withMessage(ErrorMessage.ERROR_CAR_NAME_EMPTY);
    }

    @Test
    void 자동차_이름_사이즈_예외처리() {
        //given
        String name = "pobiwoni";

        //when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.newInstance(name))
                .withMessage(ErrorMessage.ERROR_CAR_NAME_SIZE);
    }

    @Test
    void 자동자_전진() {
        //given
        String name = "pobi";
        int moveNumber = 4;
        Car car = Car.newInstance(name);

        //when
        car.move(moveNumber);

        //then
        assertThat(car.getMovementCount()).isGreaterThan(0);
    }

    @Test
    void 자동차_멈춤() {
        //given
        String name = "pobi";
        int moveNumber = 3;
        Car car = Car.newInstance(name);

        //when
        car.move(moveNumber);

        //then
        assertThat(car.getMovementCount()).isEqualTo(0);
    }

}