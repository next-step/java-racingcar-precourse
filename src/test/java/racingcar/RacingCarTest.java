package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new Name("hello"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("난수 4가 입력되었을 경우 자동차는 한칸 전진한다.")
    void move(int random) {
        // given
        TravelDistance one = TravelDistance.create(1);

        // when
        racingCar.moveForward(random);
        TravelDistance travelDistance = racingCar.getTravelDistance();

        // then
        assertThat(travelDistance).isEqualTo(one);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("난수 3이 입력되었을 경우 자동차는 이동하지 않는다.")
    void stop(int random) {
        // given
        TravelDistance zero = new TravelDistance();

        // when
        racingCar.moveForward(random);
        TravelDistance travelDistance = racingCar.getTravelDistance();

        // then
        assertThat(travelDistance).isEqualTo(zero);
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하여야 한다.")
    void name_should_be_less_than_or_equals_five() {
        // given
        String name = "greatThanFive";

        // when then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }
}
