package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.Validation;

public class ValidationTest {
    @Test
    void 영문_4자(){
//        Assertions.assertThatThrownBy(()->Validation.driverName("pobi")).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(()-> Validation.driverName("pobii")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->Validation.driverName("pob1")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->Validation.driverName("pobi5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수_0이상(){
//        Assertions.assertThatThrownBy(()->Validation.round(1)).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(()->Validation.round(0)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->Validation.round(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
