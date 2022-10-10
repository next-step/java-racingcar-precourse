package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "jue", "jina", "abcde", "트위스티드"})
    void 자동차_이름은_5자_이하만_가능하다(String name) {
        // given
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 5자 초과시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "aaaaaaa", "트리스타나아"})
    void 자동차_이름은_5자_초과시_예외가_발생한다(String name) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class)
                                               .hasMessageStartingWith("[ERROR] 자동차 이름은 5자 이하만 가능합니다. length:");
    }

    @DisplayName("자동차 이름이 빈값이면 예외가 발생한다")
    @Test
    void 자동차_이름이_빈값이면_예외가_발생한다() {
        // given
        String name = "";

        // when
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class)
                                               .hasMessageStartingWith("[ERROR] 자동차 이름은 빈값일 수 없습니다.");
    }

    @DisplayName("자동차는 random 값이 4 이상일 경우 전진한다")
    @Test
    void 자동차는_random_값이_4_이상일_경우_전진한다() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            // given
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(CarState.MOVING_FORWARD.getNo());

            // when
            // then
            car.move();
            assertThat(car.getDistance()).isEqualTo(1);

            car.move();
            assertThat(car.getDistance()).isEqualTo(2);
        }
    }

    @DisplayName("자동차는 random 값이 3 이하일 경우 멈춘다")
    @Test
    void 자동차는_random_값이_3_이하일_경우_멈춘다() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            // given
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(CarState.STOP.getNo());

            // when
            // then
            car.move();
            assertThat(car.getDistance()).isEqualTo(0);

            car.move();
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
}