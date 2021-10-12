package racinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,crong,honux,gaeul",
            " pobi,crong,honux,gaeul ",
            "pobi, crong, honux, gaeul",
            ",pobi,crong,honux,gaeul",
            "pobi,crong,honux,gaeul,"})
    void 자동차_이름을_반환한다(String input) {
        List<String> carNames = CarNameParser.parse(input);
        assertThat(carNames).containsExactly("pobi", "crong", "honux", "gaeul");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름이_1개_이상_존재하지_않을_경우_예외를_던진다(String input) {
        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1개 이상의 자동차 이름이 필요합니다");
    }
}
