package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("이름 길이가 5자 이상이면 True return")
    void checkNameLengthTest() {

        // given
        String grace = "grace";
        String mia = "mia";
        String sophia = "sophia";

        // when
        boolean checkGrace = Validation.checkNameLength(grace);
        boolean checkMia = Validation.checkNameLength(mia);
        boolean checkSophia = Validation.checkNameLength(sophia);

        // then
        assertThat(checkGrace).isTrue();
        assertThat(checkMia).isTrue();
        assertThat(checkSophia).isFalse();
    }
}
