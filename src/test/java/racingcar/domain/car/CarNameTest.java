package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarName;

public class CarNameTest {
    @Test
    @DisplayName("CarName 도메인이 생성되는 지")
    void shouldBeCreated() {
        CarName carName = CarName.from("steve");

        Assertions.assertEquals("steve", carName.getValue());
    }

    @Test
    @DisplayName("빈 값일 때 오류를 반환하는 지")
    void shouldThrowExceptionWhenEmptyValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.from(""))
                .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("제한된 길이 이상의 값일 때 오류를 반환하는 지")
    void shouldThrowExceptionWhenInvalidLengthValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.from("thisisover5char"))
                .withMessageContaining("[ERROR]");
    }
}
