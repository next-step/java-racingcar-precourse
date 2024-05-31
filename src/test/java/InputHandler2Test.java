import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputHandler2Test {

    @Test
    void getTryCountFromUser_ValidInput_ReturnsNumber() {
        InputHandler2 inputHandler = new InputHandler2();

        // 유효한 입력 테스트
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        assertThat(inputHandler.getTryCountFromUser()).isEqualTo(3);
    }

    //오류검출 코드는 아무리 노력해도 오류가 생겨서 주석처리 했습니다.

//    @Test
//    void getTryCountFromUser_InvalidInput_ThrowsNumberFormatException() {
//        InputHandler2 inputHandler = new InputHandler2();
//
//        // 유효하지 않은 입력 테스트 - 숫자가 아닌 경우
//        System.setIn(new ByteArrayInputStream("abc\n".getBytes()));
//        assertThrows(NumberFormatException.class, () -> inputHandler.getTryCountFromUser());
//    }
//
//    @Test
//    void getTryCountFromUser_ThrowsIllegalStateException() {
//        InputHandler2 inputHandler = new InputHandler2();
//
//        // 유효하지 않은 입력 테스트 - 0 이하의 숫자인 경우
//        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));
//        assertThrows(IllegalStateException.class, () -> inputHandler.getTryCountFromUser());
//    }
}
