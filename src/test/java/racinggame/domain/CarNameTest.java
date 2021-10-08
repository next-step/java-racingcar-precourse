package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @Test
    void 생성확인() {
        CarName carName = new CarName("abcd");
        assertThat(carName.getName()).isEqualTo("abcd");
    }

    @Test
    void 이름이_5글자_이상일_때_에러발생_확인() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("abcdef"))
                .withMessageContaining("[ERROR]");
    }
}