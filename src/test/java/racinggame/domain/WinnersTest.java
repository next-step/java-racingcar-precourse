package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void testEquals() {
        assertThat(new Winners(Arrays.asList(new Name("1"), new Name("2")))
            .equals(new Winners(Arrays.asList(new Name("1"), new Name("2"))))).isEqualTo(true);

        assertThat(new Winners(Arrays.asList(new Name("1"), new Name("2")))
            .equals(new Winners(Arrays.asList(new Name("1"))))).isEqualTo(false);
    }
}