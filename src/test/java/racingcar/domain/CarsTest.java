package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;
import java.util.Arrays;



class CarsTest {

    private Cars cars;

    @Test
    void 자동차이름_입력후_사이즈검증() {
        cars = new Cars(Arrays.asList(new Car(new Name("pobi"), new Position(0))
                , new Car(new Name("woni"), new Position(0))
                , new Car(new Name("jun"), new Position(0))
                , new Car(new Name("crong"), new Position(0))
        ));
        assertThat(cars.getCarList().size()).isEqualTo(4);
    }

    @Test
    void 자동차이름_2개미만_입력시_예외() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                new Cars(Arrays.asList(new Car(new Name("pobi"), new Position(0))
                ))
        );
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_MIN_CARS_COUNT);
    }

    @Test
    void 자동차이름_5글자_이상_입력시_예외() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                new Cars(Arrays.asList(new Car(new Name("pobi"), new Position(0))
                        , new Car(new Name("crong"), new Position(0))
                        , new Car(new Name("javaji"), new Position(0))
                ))
        );
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_MAX_CAR_NAME_LENGTH);
    }
}