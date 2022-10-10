package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 생성 확인")
    void createCar() {
        Car carFromObjects = Car.of(CarName.from("TEST"), new CarPosition());
        Car carFromName = Car.fromName("TEST");

        assertAll(
                () -> assertThat(carFromObjects.getName()).isEqualTo("TEST"),
                () -> assertThat(carFromName.getName()).isEqualTo("TEST"),
                () -> assertThat(carFromObjects.getPosition()).isEqualTo(0),
                () -> assertThat(carFromName.getPosition()).isEqualTo(0)
        );
    }
}
