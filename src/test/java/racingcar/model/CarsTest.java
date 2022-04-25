package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("Cars 생성")
    @Test
    public void create() {
        Cars cars = new Cars("a,b,c");
    }

    @DisplayName("Cars 생성 예외 : 참가자는 2명 이상")
    @Test
    public void create_invalid_size() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Cars("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}