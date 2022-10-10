package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarsTest {

    @DisplayName("자동차 리스트에서 원하는 자동차를 조회할 수 있다")
    @Test
    void 자동차_리스트에서_원하는_자동차를_조회할_수_있다() {
        // given
        Cars cars = new Cars(new String[]{"a", "b", "c"});

        // when
        Car car1 = cars.getCar(0);
        Car car2 = cars.getCar(1);
        Car car3 = cars.getCar(2);

        // then
        assertThat(cars.getRaceCarCount()).isEqualTo(3);
        assertThat(car1.getName()).isEqualTo("a");
        assertThat(car2.getName()).isEqualTo("b");
        assertThat(car3.getName()).isEqualTo("c");
    }

    @DisplayName("존재하지 않는 자동차 리스트 조회 시 예외가 발생한다")
    @Test
    void 존재하지_않는_자동차_리스트_조회_시_예외가_발생한다() {
        // given
        Cars cars = new Cars(new String[]{"a", "b"});

        // when
        // then
        Assertions.assertThatThrownBy(() -> cars.getCar(2))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageStartingWith("[ERROR] 조회 할 자동차가 존재하지 않습니다.");
    }

    @Test
    void name() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            // given
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(CarState.MOVING_FORWARD.getNo());
            Cars cars = new Cars(new String[]{"a", "b"});

            // when
            cars.race();

            // then
            Car car1 = cars.getCar(0);
            Car car2 = cars.getCar(1);

            assertThat(car1.getName()).isEqualTo("a");
            assertThat(car1.getDistance()).isEqualTo(1);
            assertThat(car2.getName()).isEqualTo("b");
            assertThat(car2.getDistance()).isEqualTo(1);
        }
    }
}