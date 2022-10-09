package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesTest {

    @Test
    @DisplayName("등록되는_이름은_','(쉼표)로_구분되어야_한다")
    void validate() {
        assertDoesNotThrow(() -> {
            CarNames carNames = new CarNames("안녕하세요,나는,자동차임");
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNames carNames = new CarNames("한글이나,영어만,가능_특수");
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 한글이나 영어만 가능합니다.");
    }

    @Test
    @DisplayName("등록되는_이름은_무조건_존재해야_한다")
    void validateLength() {
        assertDoesNotThrow(() -> {
            CarNames carNames = new CarNames("안녕하세요,나는,자동차임");
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNames carNames = new CarNames("안녕하세요,,자동차임");
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("등록되는_이름은_무조건_유일해야_한다")
    void validateDuplication() {
        assertDoesNotThrow(() -> {
            CarNames carNames = new CarNames("안녕하세요,나는,자동차임");
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNames carNames = new CarNames("안녕하세요,안녕하세요,자동차임");
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
