package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarTest {
    @DisplayName("5자 넘는 이름으로 생성시 에러 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = {"six666", "seven77"})
    void nameLengthOver(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void create(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤값으로 이동 가능한 값이 나왔을 경우")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 9 })
    void movableValue(int randomValue) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(randomValue);
            Car car = new Car("TEST");
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("랜덤값으로 이동 불가능한 값이 나왔을 경우")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void notMovableValue(int randomValue) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomValue);
            Car car = new Car("TEST");
            car.move();
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}