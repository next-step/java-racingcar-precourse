package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.Validation;

class RacingCarsTest {
    RacingCars racingCars = null;
    Validation validation = new Validation();

    @BeforeEach
    void setUp() {
        String inputValue = "abc,def,asdf,qwert,1234";
        racingCars = new RacingCars();
        racingCars.createCar(inputValue);
    }

    @Test
    void 쉼표_기준으로_분리() {
        // given
        // when
        // then
        assertEquals(racingCars.getCarList().size(), 5);
    }

    @Test
    void 자동차_이름_5자_이상_예외처리() {
        String inputValue = "abc,def,asdf,qwert,1234,sfsadfs";
        // given
        // when
        Throwable thrown = catchThrowable(() -> {
            validation.validationCarName(inputValue);
        });
        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 경주할 자동차 이름은 5자");

    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void 자동차_입력_값이_4이상이면_전진(int randomValue, int forwardCount) {
        // given
        // when
        int forward = racingCars.forward(randomValue);
        // then
        assertEquals(forward, forwardCount);

    }

}