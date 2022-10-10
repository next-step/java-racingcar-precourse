package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void 제한된_글자수_이내_자동차_이름_만들기() {
        assertThat(new CarName("가").getName().length()).isLessThanOrEqualTo(CarName.CAR_NAME_MAX_LENGTH);
        assertThat(new CarName("가나다라마").getName().length()).isLessThanOrEqualTo(CarName.CAR_NAME_MAX_LENGTH);
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
        assertThrows(IllegalArgumentException.class, () -> new CarName("가나다라마바사"));
    }
}