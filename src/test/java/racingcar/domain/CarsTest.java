package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Error;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @DisplayName("자동차 이름은 중복되면 안 된다")
    @Test
    void 자동차_이름_중복_예외_테스트() {
        assertThatThrownBy(() -> {
            new Cars(Arrays.asList(new Car("차"), new Car("차")));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.DUPLICATE_NAME.toString());
    }
}
