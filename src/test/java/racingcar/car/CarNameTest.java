package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"hong", "crong", "pobi", "hounx", " pobi "})
    @DisplayName("자동차 이름 생성 성공 테스트")
    void of(String name) {
        // given

        // when
        final CarName carName = CarName.of(name);

        // then
        assertThat(carName.getName()).isEqualTo(name.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", " asda  asd ", "", })
    @DisplayName("자동차 이름 생성 실패 테스트")
    void of_exception(String name) {
        // given

        // when & then
        assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class);

    }
}