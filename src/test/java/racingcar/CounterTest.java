package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterTest {
    @Test
    void testCountDown() {
        Counter counter = new Counter(3);
        assertThat(counter.isFinish()).isEqualTo(false);
        counter.countDown();
        assertThat(counter.isFinish()).isEqualTo(false);
        counter.countDown();
        assertThat(counter.isFinish()).isEqualTo(false);
        counter.countDown();
        assertThat(counter.isFinish()).isEqualTo(true);
    }
}
