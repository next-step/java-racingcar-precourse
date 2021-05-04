package com.example.racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @Test
    void getDistance_IsValid() {
        Distance distance = new Distance();
        distance.go();
        distance.go();
        assertThat(distance.getDistance())
                .isEqualTo(2);
    }

    @Test
    void newName_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> { new Name("aaaaaa"); });
        assertThatIllegalArgumentException().isThrownBy(() -> { new Name(""); });
        assertThatIllegalArgumentException().isThrownBy(() -> { new Name(null); });
    }

    @Test
    void newName_ShouldNotThrowException() {
        assertThatCode(() -> { new Name("aaa"); }).doesNotThrowAnyException();
    }
}