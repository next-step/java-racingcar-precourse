package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.Constants.*;

public class DriveNumberTest {

    @Test
    void 생성() {
        DriveNumber driveNumber = new DriveNumber("5");
        assertThat(driveNumber.getValue()).isEqualTo(5);
    }

    @Test
    void 생성_예외_1() {
        assertThatThrownBy(() -> {
            new DriveNumber("x");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DRIVE_NUMBER_NOT_INTEGER_EXCEPTION_MESSAGE);
    }

    @Test
    void 생성_예외_2() {
        assertThatThrownBy(() -> {
            new DriveNumber("3.14");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DRIVE_NUMBER_NOT_INTEGER_EXCEPTION_MESSAGE);
    }

    @Test
    void 생성_예외_3() {
        assertThatThrownBy(() -> {
            new DriveNumber("-1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DRIVE_NUMBER_NEGATIVE_EXCEPTION_MESSAGE);
    }
}
