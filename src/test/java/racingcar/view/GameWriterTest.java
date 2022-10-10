package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("view ( GameWriterTest )")
class GameWriterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void after() {
        System.setOut(originOut);
    }

    @Test
    @DisplayName("자동차 이름 질의문 출력")
    void number_inquire_write_test() {
        // Given
        String testingStr = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

        // When
        GameWriter.inquireCarNames();

        // Then
        assertThat(testingStr).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("라운드수 질의문 출력")
    void rounds_inquire_write_test() {
        // Given
        String testingStr = "시도할 회수는 몇회인가요?";

        // When
        GameWriter.inquireRounds();

        // Then
        assertThat(testingStr).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("라운드 시작전 안내메시지 출력")
    void info_before_round_start_write_test() {
        // Given
        String testingStr = "실행 결과(실행 결과는 누적 전진수를 의미합니다. - 문자는 한칸을 전진했다는걸 의미합니다.)";

        // When
        GameWriter.writeInfoBeforeRoundStart();

        // Then
        assertThat(testingStr).isEqualTo(outputStream.toString().trim());
    }
}