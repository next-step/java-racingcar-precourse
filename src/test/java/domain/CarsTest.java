package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    @DisplayName("자동차들의 이름입력")
    void name() {
        Cars cars = new Cars("a,b,c");
        assertThat(cars.size()).isEqualTo(3);
    }
}
