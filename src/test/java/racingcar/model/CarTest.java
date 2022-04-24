package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.Sign;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final String carName = "pobi";
    Car pobiCar;

    @BeforeEach
    void initialize() {
        pobiCar = new Car(carName);
    }

    @Test
    void 자동차_이름_등록_성공() {
        // Then
        assertThat(pobiCar.getCarName())
            .isNotEmpty()
            .isEqualTo(carName);
    }

    @Test
    void 자동차_전진() {
        //given
        int movingForward = 4;
        //when
        pobiCar.drive(movingForward);
        //then
        assertThat(pobiCar.getHeadway())
            .isEqualTo(1);
    }

    @Test
    void 자동차_멈춤() {
        //given
        int movingForward = 3;
        //when
        pobiCar.drive(movingForward);
        //then
        assertThat(pobiCar.getHeadway())
            .isEqualTo(0);
    }

    @Test
    void 자동차_상태() {
        //given
        int movingForward = 4;
        //when
        pobiCar.drive(movingForward);
        //then
        assertThat(pobiCar.getStatus())
            .isEqualTo(carName + Sign.CONNECTION_SIGN.getSign() + Sign.HEADWAY_SIGN.getSign());
    }
}
