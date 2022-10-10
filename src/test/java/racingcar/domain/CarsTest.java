package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {

    @DisplayName("Car를 리스트로 가지는 Cars 일급컬렉션을 생성한다.")
    @Test
    void construct() {
        Cars cars = new Cars("car1, car2, car3");
        assertThat(cars).isNotNull();
    }

    @DisplayName("Cars에 입력되는 값들 중 빈값, 올바르지 않은 구분자 등을 Car 인스턴스 생성하며 예외가 발생하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "car1/car2"})
    void constructFail(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(names));
    }
}
