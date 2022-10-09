package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDistanceTest {
    public static final int MOVE = 9;
    public static final int STOP = 1;


    @DisplayName("승자를 알 수 있다")
    @Test
    void 승자_테스트() {
        Car winner = new Car("승자");
        winner.move(MOVE);

        Car loser = new Car("패자");
        loser.move(STOP);

        assertThat(new CarDistance(Arrays.asList(winner, loser)).winner()).contains("승자");
    }

    @DisplayName("승자는 여러명 일 수 있다")
    @Test
    void 다중_승자_테스트() {
        Car winner = new Car("승자1");
        winner.move(MOVE);

        Car loser = new Car("승자2");
        loser.move(MOVE);

        assertThat(new CarDistance(Arrays.asList(winner, loser)).winner()).contains("승자1", "승자2");

    }
}
