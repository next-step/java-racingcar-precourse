package com.example.racingcar;

import org.junit.jupiter.api.Test;

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
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("aaaaaa"));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(null));
    }

    @Test
    void newName_ShouldNotThrowException() {
        assertThatCode(() -> new Name("aaa")).doesNotThrowAnyException();
    }

    @Test
    void newCar_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
    }

    @Test
    void newCar_ShouldNotThrowException() {
        assertThatCode(() -> new Car(new Name("aaa"))).doesNotThrowAnyException();
    }
}
