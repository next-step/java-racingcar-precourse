package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSetTest {

    @Test
    void create() {
        CarSet set = new CarSet(new Car("abc"), new Car("def"));

        assertThat(set.length()).isEqualTo(2);
    }
}
