package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @DisplayName("다섯자_이하_한자이상으로_입력되면_정상_생성")
    @ParameterizedTest
    @ValueSource(strings = {"car", "0", "abcd", "01234", "aa"})
    void 다섯자_이하_한자이상으로_입력되면_정상_생성(String name) {
        assertThatNoException().isThrownBy(() -> new CarName(name));
    }

    @DisplayName("다섯자_이상_0이하로_이름이_입력되면_에러_발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "012345"})
    void 다섯자_이상_0이하로_이름이_입력되면_에러_발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name));
    }
}
