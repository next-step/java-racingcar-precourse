import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.GameController;

public class CarNameValidationTest {
    GameController gameController;

    @Test
    @DisplayName("입력문자열이_정상적인_배열로_변환되는지_테스트")
    void test01 () {
        String input = "man1,man2,man3";
        String[] result = gameController.getCarNames(input);
        String[] expectedResult = {"man1", "man2", "man3"};
        assertArrayEquals(result, expectedResult, "두 배열이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("입력에_빈칸이_발생해도_정상적인_배열로_변환되는지_테스트")
    void test02 () {
        String input = "man1,man2, man3";
        String[] result = gameController.getCarNames(input);
        String[] expectedResult = {"man1", "man2", "man3"};
        assertArrayEquals(result, expectedResult, "두 배열이 일치하지 않습니다.");
    }
}
