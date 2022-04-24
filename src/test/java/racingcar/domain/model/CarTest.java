package racingcar.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.core.common.error.CarErrorCode;
import racingcar.domain.dto.PlayHistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    private Car car;
    private String carName;

    @BeforeEach
    void setup() {
        carName = "제네시스";
        car = new Car(carName);
    }

    @Test
    void 입력값이_4_이상_이면_전진() {
        //given
        int pickNumber = 4;

        //when
        car.moveForward(pickNumber);

        //then
        assertEquals(car.getDistance(), 1);
    }

    @Test
    void 입력값이_3_이하_이면_멈춤() {
        //given
        int pickNumber = 3;

        //when
        car.moveForward(pickNumber);

        //then
        assertEquals(car.getDistance(), 0);
    }

    @Test
    void 입력값이_1_9_사이_값이_아닐때_10인_경우() {
        //given
        int pickNumber = 10;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    car.moveForward(pickNumber);
                });

        //then
        assertEquals(CarErrorCode.NOT_ALLOW_PICK_NUMBER.getErrorMessage(), exception.getMessage());
    }


    @Test
    void 입력값이_1_9_사이_값이_아닐때_0인_경우() {
        //given
        int pickNumber = 0;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    car.moveForward(pickNumber);
                });

        //then
        assertEquals(CarErrorCode.NOT_ALLOW_PICK_NUMBER.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 이동_기록_확인() {
        //given
        int pickNumber = 4;

        //when
        PlayHistory playHistory = car.moveForward(pickNumber);

        //then
        assertEquals(playHistory.getCarName(), carName);
        assertEquals(playHistory.getDistance(), 1);
    }

    @Test
    void 멈춤_기록_확인() {
        //given
        int pickNumber = 3;

        //when
        PlayHistory playHistory = car.moveForward(pickNumber);

        //then
        assertEquals(playHistory.getCarName(), carName);
        assertEquals(playHistory.getDistance(), 0);
    }
}