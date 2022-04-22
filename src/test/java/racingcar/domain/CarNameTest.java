package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarNameTest {

    @Test
    public void 생성_성공() {
        String name = "test";
        assertAll(() -> new CarName(name));
    }

    @Test
    public void 생성_오류() {
        String name = "test123";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name));
    }

    @Test
    public void 생성_빈이름_오류() {
        String name = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name));
    }

    @Test
    public void 생성_Blank_이름_오류() {
        String name = "    ";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name));
    }
}
