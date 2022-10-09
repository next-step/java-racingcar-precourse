package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(new String[]{"가", "나", "다"});
    }

    @Test
    void 자동차_입력_값은_2개_이상() {
        assertThatNoException()
                .isThrownBy(() -> new Cars(new String[]{"가", "나"}));
    }

    @Test
    void 자동차_입력_값은_2개_미만_예외() {
        assertThatThrownBy(() -> new Cars(new String[]{"가"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
