package racingcar.domain.model;

import org.junit.jupiter.api.Test;
import racingcar.core.common.error.CarErrorCode;
import racingcar.core.common.error.CommonErrorCode;
import racingcar.core.common.helper.NsPickNumberStrategy;
import racingcar.core.common.helper.PickNumberStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    private PickNumberStrategy pickNumberStrategy = new NsPickNumberStrategy();

    @Test
    void 자동차_이름이_null일_때() {
        //given
        String carNames = null;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(carNames, pickNumberStrategy);
                });

        //then
        assertEquals(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage(), exception.getMessage());
    }

    @Test
    void picknumber_전략이_null일_때() {
        //given
        String carNames = "a";
        pickNumberStrategy = null;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(carNames, pickNumberStrategy);
                });

        //then
        assertEquals(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 자동차_이름이_empty일_때() {
        //given
        String carNames = "           ";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(carNames, pickNumberStrategy);
                });

        //then
        assertEquals(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage(), exception.getMessage());
    }

    @Test
    public void 중복된_이름을_포할할_때() throws Exception {
        //given
        String carNames = "a,a,a,a,a,a,a";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(carNames, pickNumberStrategy);
                });

        //then
        assertEquals(CarErrorCode.EXIST_DUPLICATE_CAR_NAME.getErrorMessage(), exception.getMessage());
    }
}