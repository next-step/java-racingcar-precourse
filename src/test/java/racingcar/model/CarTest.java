package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class CarTest {

    static MockedStatic<Randoms> mock;

    @BeforeAll
    static void beforeAll() {
        mock = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        mock.close();
    }

    @DisplayName("랜덤 값 0~3은 자동차 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤값_0에서_3_까지는_멈춤(int i) {
        //given
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(i);
        Car car = new Car("car");

        //when
        car.move();

        //then
        assertThat(car.getDistance()).isEqualTo(Car.CAR_DISTANCE_INIT);
    }

    @DisplayName("랜덤 값 4~9는 자동차 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤값_4에서_9_까지는_전진(int i) {
        //given
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(i);
        Car car = new Car("car");

        //when
        car.move();

        //then
        assertThat(car.getDistance()).isEqualTo(Car.MOVE_UNIT);
    }

}