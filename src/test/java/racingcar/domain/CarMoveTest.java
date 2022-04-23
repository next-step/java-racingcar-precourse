package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.domain.strategy.RandomNumberMoveStrategy;

public class CarMoveTest {
    private MockedStatic<Randoms> randoms;

    @BeforeEach
    void before() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void after() {
        randoms.close();
    }

    @DisplayName("랜덤값이 4미만이라면 차량은 이동하지 않고 제자리에 있어야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void car_not_move_test(int randomNumber) {
        Car car = new Car("test", new RandomNumberMoveStrategy());

        when(Randoms.pickNumberInRange(0, 9))
                .thenReturn(randomNumber);

        car.move();
        assertThat(car.getDistanceCount()).isEqualTo(0);
    }

    @DisplayName("랜덤값이 4이상이라면 차량은 전진해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void car_move_test(int randomNumber) {
        Car car = new Car("test", new RandomNumberMoveStrategy());

        when(Randoms.pickNumberInRange(0, 9))
                .thenReturn(randomNumber);

        car.move();
        assertThat(car.getDistanceCount()).isEqualTo(1);
    }
}
