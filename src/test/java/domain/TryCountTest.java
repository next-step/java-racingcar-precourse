package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TryCountTest {
    @Test
    @DisplayName("실행 카운트는 양수여야 한다")
    public void 실행_카운트는_양수여야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryCount(0));
    }
}
