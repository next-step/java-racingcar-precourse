package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TryCountTest {

    @DisplayName("시도 횟수가 0 이 되면 False 를 리턴하는 지 확인")
    @Test
    void testCounting() {
        int count = 3;
        TryCount tryCount = new TryCount(Integer.toString(count));

        for (int i = 0; i < count; i++) {
            assertThat(tryCount.isTrying()).isTrue();
            tryCount.decreaseCount();
        }

        assertThat(tryCount.isTrying()).isFalse();
    }
}
