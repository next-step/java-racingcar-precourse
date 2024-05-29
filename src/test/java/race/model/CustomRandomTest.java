package race.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomRandomTest {
    @Test
    @DisplayName("4 이상일 때, ture 를 반환하는 지 테스트")
    void test_canMoveTrue() {
        // given
        CustomRandom customRandom = new CustomRandom() {
            @Override
            public int nextInt(int bound) {
                return 6;
            }
        };

        // when, then
        assertThat(customRandom.canMove())
                .isTrue();
    }

    @Test
    @DisplayName("4 미만일 때, false 를 반환하는 지 테스트")
    void test_canMoveFalse() {
        // given
        CustomRandom customRandom = new CustomRandom() {
            @Override
            public int nextInt(int bound) {
                return 2;
            }
        };

        // when, then
        assertThat(customRandom.canMove())
                .isFalse();
    }

}