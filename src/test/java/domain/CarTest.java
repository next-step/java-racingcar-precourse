package domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static view.MessageConstant.EXCEED_CAR_NAME_ERROR;


class CarTest {

    @ParameterizedTest
    @CsvSource({"a,su,tom,toby,david"})
    @DisplayName("자동차_이름_길이_검증")
    public void 자동차_이름_길이_검증(String name) {
        assertDoesNotThrow(() -> {
            new Car(name);
        });
    }

    @ParameterizedTest
    @CsvSource({"potato,nextstep"})
    @DisplayName("자동차_이름_길이_검증_예외")
    public void 자동차_이름_길이_검증_예외(String name) {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(EXCEED_CAR_NAME_ERROR);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @DisplayName("자동차_운전_테스트")
    public void 자동차_운전_테스트(int randomCondition, int expectedPosition) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomCondition);
            Car car = new Car("test");
            car.drive();
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }

    @ParameterizedTest
    @CsvSource({"-1", "10", "20"})
    @DisplayName("자동차_운전_테스트_예외")
    public void 자동차_운전_테스트_예외(int randomCondition) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomCondition);
            assertThrows(IllegalArgumentException.class, () -> {
                Car car = new Car("test");
                car.drive();
            });
        }
    }

}