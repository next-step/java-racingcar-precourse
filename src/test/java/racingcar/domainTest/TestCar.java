package racingcar.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;
import racingcar.domain.name.Name;

public class TestCar {

    private Name 자동차1;
    private Name 자동차2;

    @BeforeEach
    void beforeSetting() {
        자동차1 = new Name("자동차1");
        자동차2 = new Name("자동차2");
    }

    @Test
    @DisplayName("자동차 테스트")
    void 자동차_테스트() {
        // given
        final Name 자동차1 = new Name("자동차1");
        Position position = new Position(0);
        Car car = new Car(자동차1,position);
        // when, then
        car.move();
        System.out.println("car = " + car);
        assertThat(car).isNotNull();
    }


}
