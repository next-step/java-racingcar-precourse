package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {
    @Test
    void 자동차_생성() {
        Name name = new Name("pobi");
        Position position = new Position(0);

        Car car = new Car(name, position);

        assertThat(car).isEqualTo(new Car(new Name("pobi"), new Position(0)));
    }

    @Test
    void 자동차_위치를_전진시킨다() {
        Name name = new Name("pobi");
        Position position = new Position(0);
        Car car = new Car(name, position);

        assertAll(
                () -> assertThat(car.forward()).isEqualTo(new Car(new Name("pobi"), new Position(1))),
                () -> assertThat(car.forward()).isNotEqualTo(new Car(new Name("pobi"), new Position(0)))
        );
    }

    @Test
    void 자동차_위치를_반환한다() {
        Name name = new Name("pobi");
        Position position = new Position(0);
        Car car = new Car(name, position);

        assertThat(car.position()).isEqualTo(new Position(0));
    }
}
