package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Sign;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    Cars cars;

    @BeforeEach
    void initialize() {
        cars = new Cars("pobi, woni , jun");
    }

    @Test
    void 자동차들_등록_성공() {
        // Then
        assertThat(cars.getNumberOfCars())
            .isEqualTo(3);
    }

    @Test
    void 자동차들_등록_공백실패() {
        // Given
        String carNames = "pobi, , jun";
        // When & Then
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    void 자동차들_등록_5자이하실패() {
        // Given
        String carNames = "pobiwo, woni, jun";
        // When & Then
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.WRONG_CAR_NAME.getMessage());
    }

    @Test
    void 자동차_전진() {
        // Given
        int carNumber = 0;
        int engin = 4;
        // When & Then
        cars.carDrive(carNumber, engin);
        assertThat(cars.getCarStatus(carNumber))
            .isEqualTo("pobi" + Sign.CONNECTION_SIGN.getSign() + Sign.HEADWAY_SIGN.getSign());
    }

    @Test
    void 자동차_멈춤() {
        // Given
        int carNumber = 1;
        int engin = 3;
        // When & Then
        cars.carDrive(carNumber, engin);
        assertThat(cars.getCarStatus(carNumber))
            .isEqualTo("woni" + Sign.CONNECTION_SIGN.getSign());
    }

    @Test
    void 자동차_경주_우승자_이름() {
        // When
        cars.carDrive(0, 0);
        cars.carDrive(1, 0);
        cars.carDrive(2, 0);

        cars.carDrive(0, 0);
        cars.carDrive(1, 4);
        cars.carDrive(2, 5);

        cars.carDrive(0, 0);
        cars.carDrive(1, 6);
        cars.carDrive(2, 7);
        // Then
        assertThat(cars.getWinner())
            .isEqualTo("woni" + Sign.WINNER_JOIN_SIGN.getSign() + "jun");
    }
}
