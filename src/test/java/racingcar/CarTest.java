package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {

    public static MockedStatic<Randoms> mock;

    @BeforeAll
    static void beforeAll() {
        mock = mockStatic(Randoms.class);
    }

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    public void give_a_car_name() {
        Car car = new Car("car");
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        assertThat(car.getName()).isEqualTo("car");
        assertThat(car1.getName()).isEqualTo("car1");
        assertThat(car2.getName()).isEqualTo("car2");
    }

    @ParameterizedTest
    @DisplayName("random 값이 4이상일 경우 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void goCondition(int i) {
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(i);

        Car car = new Car("go");
        car.depart();
        assertThat(car.getForwardCount()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("random 값이 3이하의 값이면 멈춘다.")
    @ValueSource(ints = {0, 1, 2, 3})
    public void stopCondition(int i) {
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(i);

        Car car = new Car("stop");
        car.depart();
        assertThat(car.getForwardCount()).isEqualTo(0);
    }

}
