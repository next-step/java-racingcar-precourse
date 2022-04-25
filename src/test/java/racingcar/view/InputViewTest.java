package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("콤마로 구분한 문자열 배열을 입력받는다.")
    @Test
    public void inputCarsNames() {
        //given
        InputView inputView = new InputView();
        String input = "최용락,용,락,용락";

        //when
        String[] names = inputView.inputCarsNames(() -> input);

        //then
        assertEquals(4, names.length);
        assertEquals(names[0], "최용락");
        assertEquals(names[1], "용");
        assertEquals(names[2], "락");
        assertEquals(names[3], "용락");
    }

    @DisplayName("움직일 횟수를 입력 받는다.")
    @Test
    public void inputCarsMoveCount() {
        //given
        InputView inputView = new InputView();

        //when
        int count = inputView.inputCarsMoveCount(() -> "1");

        //then
        assertEquals(1, count);
    }

    @DisplayName("움직일 횟수에 숫자가 아닌값을 입력하면 NumberFormatException 발생")
    @Test
    public void inputCarsMoveCount_fail_numberFormatException() {
        //given
        InputView inputView = new InputView();

        //expect
        assertThrows(NumberFormatException.class, () -> inputView.inputCarsMoveCount(() -> "a"));
    }

}