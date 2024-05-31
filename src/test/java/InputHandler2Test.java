import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandler2Test {
    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUpInput() {
        // 기본적으로 빈 입력 스트림 설정
        testIn = new ByteArrayInputStream("".getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        // 테스트 후 원래 System.in 복원
        System.setIn(originalSystemIn);
    }

    @Test
    void ValidInput_ReturnsNumber() {
        InputHandler2 inputHandler = new InputHandler2();
        testIn = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(testIn);

        assertThat(inputHandler.getTryCountFromUser()).isEqualTo(3);
    }

    @Test
    void InvalidInput() {
        InputHandler2 inputHandler = new InputHandler2();
        testIn = new ByteArrayInputStream("abc\n3\n".getBytes());
        System.setIn(testIn);

        assertThat(inputHandler.getTryCountFromUser()).isEqualTo(3);
    }

    @Test
    void InvalidNegativeInput() {
        InputHandler2 inputHandler = new InputHandler2();
        testIn = new ByteArrayInputStream("-1\n3\n".getBytes());
        System.setIn(testIn);

        assertThat(inputHandler.getTryCountFromUser()).isEqualTo(3);
    }
}
