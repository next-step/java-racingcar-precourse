package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    private final Car car = new Car("K5");

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void carNameLengthTest(int num, int expect) {
        for (int i = 0; i < num; i++) {
            car.advance();
        }
        assertThat(car.getPosition()).isEqualTo(expect);
    }

    @DisplayName("자동차 자동차 이름 null 체크")
    @Test
    void carNameNullTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(null));
    }

    @DisplayName("자동차 자동차 이름 빈값 체크")
    @Test
    void carNameZeroLengthTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(""));
    }

    @DisplayName("자동차 자동차 이름 반환 테스트")
    @Test
    void getCarNameTest() {
        assertThat(car.getCarName()).isEqualTo("K5");
    }

    @DisplayName("자동차 스냅샷 반환")
    @Test
    void getCarSnapshotTest() {
        car.advance();
        assertThat(car.getSnapshot()).isEqualTo("K5 : -");
    }
}
