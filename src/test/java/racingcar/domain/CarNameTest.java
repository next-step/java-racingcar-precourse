package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "aaaaaaaaaaaaaaa"})
    @DisplayName("차량의 이름을 정할때, 차량의 이름이 1이상 5이하의 길이가 아니면 에러가 발생된다")
    void 차량의_이름이_1이상_5이하_길이가_아니면_에러가_발생된다(String carName) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.of(carName))
                .withMessage("[ERROR] 차량명은 1글자 이상, 5글자 이하가 되어야합니다");
    }

    @Test
    @DisplayName("차량의 이름을 정할때, 공백만 있을 경우 에러가 발생된다")
    void 차량의_이름을_정할때_공백만_있을_경우_에러가_발생된다() {
        // given
        String carName = " ";

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.of(carName))
                .withMessage("[ERROR] 차량명은 1글자 이상, 5글자 이하가 되어야합니다");
    }
}
