package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("우승자를 나타내는 클래스를 생성한다.")
    @Test
    void construct() {
        Winner winner = new Winner("car1");
        assertThat(winner).isNotNull();
    }
}
