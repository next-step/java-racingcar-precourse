package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageUtilsTest {

    @Test
    @DisplayName("[ERROR]로 시작되는 메시지를 반환한다")
    void getErrorMessage() {
        assertThat(MessageUtils.getErrorMessage("a"))
                .contains(MessageUtils.ERROR_LABEL);

    }
}