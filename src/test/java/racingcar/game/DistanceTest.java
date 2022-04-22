package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    @DisplayName("isGreaterThan() 1이 0보다 큰가? 참")
    void isGreaterThan_True() {
        Distance left = new Distance(1);
        Distance right = new Distance(0);

        assertThat(left.isGreaterThan(right)).isTrue();
    }

    @Test
    @DisplayName("isGreaterThan() 0이 1보다 큰가? 거짓")
    void isGreaterThan_False() {
        Distance left = new Distance(0);
        Distance right = new Distance(1);

        assertThat(left.isGreaterThan(right)).isFalse();
    }
    @Test
    @DisplayName("isLessThan() 0이 1보다 작은가? 참")
    void isLessThan_True() {
        Distance left = new Distance(0);
        Distance right = new Distance(1);

        assertThat(left.isLessThan(right)).isTrue();
    }

    @Test
    @DisplayName("isLessThan() 1이 0보다 작은가? 거짓")
    void isLessThan_False() {
        Distance left = new Distance(1);
        Distance right = new Distance(0);

        assertThat(left.isLessThan(right)).isFalse();
    }

    @Test
    @DisplayName("equals() 0과 0은 같은가? 참")
    void isGreaterThan_Equals() {
        Distance left = new Distance(0);
        Distance right = new Distance(0);

        assertThat(left.equals(right)).isTrue();
    }
}
