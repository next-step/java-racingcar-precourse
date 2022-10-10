package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CarNameTest {
    @ParameterizedTest(name = "자동차 이름은 비지 않아야 한다. [{0}]")
    @NullAndEmptySource
    void shouldNotEmpty(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름은 비어 있지 않아야 합니다!");
    }

    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    @Test
    void shouldBeLessThanOrEqualToMaxLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("123456"))
                .withMessageMatching("자동차 이름은 5자 이하여야 합니다! 값: '123456'");
    }

    @DisplayName("자동차 이름을 문자열로 받을 수 있다.")
    @Test
    void valueToString() {
        final String value = "min";
        final CarName name = new CarName(value);
        assertThat(name.toString()).isEqualTo(value);
    }

    @DisplayName("이름 값이 같다면, 동일하다.")
    @Test
    void valueObject() {
        final CarName one = new CarName("equal");
        final CarName another = new CarName("equal");
        assertThat(one).isEqualTo(another);
    }
}
