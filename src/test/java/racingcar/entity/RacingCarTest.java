package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @DisplayName("정상 RacingCar")
    @Test
    void valid_racing_car() {
        var racingCar = new RacingCar("foo");
        assertThat(racingCar)
                .hasFieldOrPropertyWithValue("name", "foo")
                .hasFieldOrPropertyWithValue("location", 0);

        racingCar.forward();
        assertThat(racingCar)
                .hasFieldOrPropertyWithValue("name", "foo")
                .hasFieldOrPropertyWithValue("location", 1);
    }

    @DisplayName("비정상 RacingCar(이름없음)")
    @Test
    void invalid_racing_car1() {
        assertThatThrownBy(() -> {
            var racingCar = new RacingCar(" ");
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("wrong car name");
    }

    @DisplayName("비정상 RacingCar(5자 이상)")
    @Test
    void invalid_racing_car2() {
        assertThatThrownBy(() -> {
            var racingCar = new RacingCar("123456");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong car name");
    }
}