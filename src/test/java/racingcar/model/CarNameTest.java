package racingcar.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarNameTest {

    @Test
    void 차_이름_5자_이하_생성_검증() {
        CarName carName = new CarName("shinh");

        assertThat(carName).isEqualTo(new CarName("shinh"));
    }

    @Test
    void 차_이름_5자_초과_Exception_검증() {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new CarName("shinhan");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}