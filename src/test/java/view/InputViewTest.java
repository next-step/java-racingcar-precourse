package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void recoverInput() {
        System.setIn(System.in);
    }

    private void makeInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Nested
    @DisplayName("자동차 이름 입력에 대해")
    class inputCarNames {

        @Test
        @DisplayName("정상인 경우")
        void isInputCarNamesCorrect() throws IOException {
            //given
            makeInput("Car1,Car2,Car3");

            //when
            String[] carNames = inputView.inputCarNames();

            //then
            Assertions.assertArrayEquals(new String[]{"Car1", "Car2", "Car3"}, carNames);
        }

        @Test
        @DisplayName("자동차 이름 글자 수가 5 초과인 경우")
        void isInputCarNameLengthOverFive() throws IOException {
            //given
            makeInput("Alpha,Bravo,Charlie");

            //when
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                inputView.inputCarNames();
            });

            //then
            assertEquals("[Error] 자동차 이름은 1~5자 사이만 가능합니다.", exception.getMessage());
        }

        @Test
        @DisplayName("자동차 이름 글자 수가 0인 경우")
        void isInputCarNameLengthZero() throws IOException {
            //given
            makeInput(",Car2,Car3");

            //when
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                inputView.inputCarNames();
            });

            //then
            assertEquals("[Error] 자동차 이름은 1~5자 사이만 가능합니다.", exception.getMessage());
        }

    }

    @Nested
    @DisplayName("시행 횟수 입력에 대해")
    class inputTimes {

        @Test
        @DisplayName("정상인 경우")
        void isInputTimesCorrect() throws IOException {
            //given
            makeInput("5");

            //when
            int time = inputView.inputTimes();

            //then
            assertEquals(time, 5);
        }

        @Test
        @DisplayName("숫자이외의 다른 값을 입력 받았을 시")
        void isInputTimesDigit() throws IOException {
            //given
            makeInput("abc");

            //when
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                inputView.inputTimes();
            });

            //then
            assertEquals("[Error] 숫자의 형태로 입력해 주세요", exception.getMessage());
        }

        @Test
        @DisplayName("시행횟수로 0을 입력 받았을 시")
        void isInputTimesZero() throws IOException {
            //given
            makeInput("0");

            //when
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                inputView.inputTimes();
            });

            //then
            assertEquals("[Error] 최소 한번 이상의 경주횟수를 입력해 주세요", exception.getMessage());
        }
    }

}
