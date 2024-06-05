package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView(new BufferedReader(new StringReader("")));
    }

    @Test
    public void 입력_자동차_이름_테스트_정상() throws IOException {
        // given
        String input = "Car1,Car2,Car3";
        inputView = new InputView(new BufferedReader(new StringReader(input)));

        // when
        String[] carNames = inputView.inputCarNames();

        // then
        assertArrayEquals(new String[]{"Car1", "Car2", "Car3"}, carNames);
    }

    @Test
    public void 입력_자동차_이름_테스트_예외() throws IOException {
        // given
        String input = "Car1,Car2,Car999";
        inputView = new InputView(new BufferedReader(new StringReader(input)));

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, inputView::inputCarNames);
        assertEquals("[Error] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    public void 입력_시도_횟수_테스트_정상() throws IOException {
        // given
        String input = "5";
        inputView = new InputView(new BufferedReader(new StringReader(input)));

        // when
        int tryCount = inputView.inputTryCount();

        // then
        assertEquals(5, tryCount);
    }

    @Test
    public void 입력_시도_횟수_테스트_예외() {
        // given
        String input = "abc";
        inputView = new InputView(new BufferedReader(new StringReader(input)));

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, inputView::inputTryCount);
        assertEquals("[Error] 시도 횟수는 숫자만 가능합니다.", exception.getMessage());
    }
}
