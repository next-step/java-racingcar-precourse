package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void carNameValidTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("aaaaaa");
        });
    }

}
