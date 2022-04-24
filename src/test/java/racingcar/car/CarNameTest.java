package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CarName에 대해 테스트한다.")
class CarNameTest {

    @ParameterizedTest(name = "CarName을 생성하는데 성공한다. value={0}")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde", "a    ", "    e"})
    void successfulCreatingCarName(String value) {
        final CarName carName = CarName.of(value);
        assertThat(carName.value()).isEqualTo(value.trim());
    }

    @ParameterizedTest(name = "CarName을 생성하는데 실패한다. value={0}")
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "abcdef"})
    void failureCreatingCarName(String value) {
        assertThatThrownBy(() -> {
            CarName.of(value);
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @ParameterizedTest(name = "CarName는 동등성이 보장된다. value={0}")
    @ValueSource(strings = {" a", "ab ", " abc", " abcd ", "abcde  ", "a    ", "    e"})
    void deepEquals(String value) {
        final CarName carName = CarName.of(value);
        final CarName otherCarName = CarName.of(value);
        assertThat(carName).isEqualTo(otherCarName);
    }
}
