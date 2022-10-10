package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5자가 넘는 경우 IllegalStateException Exception 발생")
    void invalidName() {
        assertThatThrownBy(() ->
                new Car(new Name("christophe"))
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]:");
    }

    @Test
    @DisplayName("자동차의 이름이 1~5자 사이라면 정상계")
    void validName() {
        assertAll(
                () -> assertThat(new Car(new Name("john")).getName().getValue()).contains("john"),
                () -> assertThat(new Car(new Name("123")).getName().getValue()).contains("123"),
                () -> assertThat(new Car(new Name("john5")).getName().getValue()).contains("john5")
        );
    }

    @Test
    @DisplayName("null을 보낸경우 IllegalStateException exception을 발생시킨다")
    void name_with_value_null() {
        assertThatThrownBy(() ->
                new Car(new Name(null))
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]:");
    }

    @Test
    void move() {
        int GAME_RANGE_BEGIN = 0;
        int GAME_RANGE_END = 5;
        Car car = new Car(new Name("Mike"));
        for (int i = GAME_RANGE_BEGIN; i < GAME_RANGE_END; i++) {
            car.move();
        }
        assertThat(car.getPositionInteger()).isGreaterThanOrEqualTo(GAME_RANGE_BEGIN)
                .isLessThanOrEqualTo(GAME_RANGE_END);
    }

    @Test
    void move_100_times() {
        for (int i = 0; i < 100; i++) {
            move();
        }
    }

    @Test
    @DisplayName("should be able to retrieve carName")
    void getNameInString() {
        String carName = "john";
        Name name = new Name(carName);
        Car car = new Car(name);
        assertEquals(car.getNameInString(), carName);
    }
}
