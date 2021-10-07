package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.MoveUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveUtilsTest {

    @Test
    @DisplayName("4이상_GO_3이하_STOP")
    void isGo() {
        assertThat(MoveUtils.isGo(3)).isFalse();
        assertThat(MoveUtils.isGo(4)).isTrue();
        assertThat(MoveUtils.isGo(1)).isFalse();
    }
}
