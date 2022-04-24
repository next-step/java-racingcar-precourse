package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Moving;
import racingcar.domain.number.GameNumberGenerator;

public class CarTest {
    @Test
    @DisplayName("Car 도메인이 생성되는 지")
    void shouldBeCreated() {
        Car car = Car.of(CarName.from("steve"), Moving.by(new GameNumberGenerator()));

        Assertions.assertEquals("steve", car.getCarName());
    }

    @Test
    @DisplayName("Car 도메인이 생성시 Track 레코드가 0으로 초기화되는 지")
    void shouldBeCreatedWithInitializedTrack() {
        Car car = Car.of(CarName.from("steve"), Moving.by(new GameNumberGenerator()));

        Assertions.assertEquals(0, car.getTrack());
    }
}
