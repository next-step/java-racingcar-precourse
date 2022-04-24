package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("자동차의 이름을 반환 한다")
    void getName() {
        assertThat(new CarName("자동차").getName()).isEqualTo("자동차");
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하 이며 공백이 될 수 없다")
    void validCarNameTest() {
        new CarName("3글자");
        assertThatIllegalArgumentException().isThrownBy(()-> new CarName("5글자넘는차"));
        assertThatIllegalArgumentException().isThrownBy(()-> new CarName(""));
        assertThatIllegalArgumentException().isThrownBy(()-> new CarName(null));
    }
}