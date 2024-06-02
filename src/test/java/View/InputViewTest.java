package View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("InputView 테스트")
class InputViewTest {

    @Test
    @DisplayName("올바른 값을 입력했는지")
    void getRounds_ValidInput_ReturnsRounds() {
        InputView inputView = new InputView();

        assertEquals(5, inputView.getRounds());
    }

    @Test
    @DisplayName("4 미만의 수를 입력하면 예외 발생하는지")
    void getRounds_InvalidInputLessThanFour_ThrowsIllegalArgumentException() {
        InputView inputView = new InputView();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputView.getRounds();
        });

        assertEquals("입력이 올바르지 않습니다. 4 이상의 값을 입력하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("10 이상 입력하면 예외 발생하는지")
    void getRounds_InvalidInputGreaterThanNine_ThrowsIllegalArgumentException() {
        InputView inputView = new InputView(); // InputView 객체 생성

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputView.getRounds();
        });

        assertEquals("입력이 올바르지 않습니다. 0에서 9 사이의 값을 입력하세요.", exception.getMessage());
    }
}