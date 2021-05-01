package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @DisplayName("5자 이하의 자동차 이름 정상적으로 생성")
    @Test
    void testConstructor() {
        String name = "abcde";
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 최대 5자")
    @Test
    void testValidateCarNameSize() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 최대 5자까지만 가능합니다.");
    }
}
