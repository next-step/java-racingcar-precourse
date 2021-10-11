package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @Test
    void 자동차_이름_생성() {
        String input = "pobi";

        Name carName = new Name(input);

        assertThat(carName.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaaaaaa"})
    void 유효하지_않은_자동차_이름(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(input))
                .withMessageContaining("[ERROR]");
    }

}
