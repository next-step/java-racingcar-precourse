package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test Ask to user ")
    void askCarNameMessage() {
        outputView.askCarNameMessage();
        assertThat(outContent.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void askTryCountMessage() {
        outputView.askTryCountMessage();
        assertThat(outContent.toString().trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void printResultMessage() {
        outputView.printResultMessage();
        assertThat(outContent.toString().trim()).isEqualTo("실행 결과");
    }

}