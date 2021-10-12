package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @DisplayName("승자 equals 제대로 동작하는지 테스트")
    @Test
    void equals_success() {
        assertThat(new Winners(Arrays.asList(new Name("1"), new Name("2")))
            .equals(new Winners(Arrays.asList(new Name("1"), new Name("2"))))).isEqualTo(true);

        assertThat(new Winners(Arrays.asList(new Name("1"), new Name("2")))
            .equals(new Winners(Arrays.asList(new Name("1"))))).isEqualTo(false);
    }
}