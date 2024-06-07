package view;

import controller.GameController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Iteration이 0이어서 car의 movemnets가 모두 0일때 우승자 테스트")
    public void testPrintGameWhenAllCarsMovementIsZero() {
        // given
        GameController gameController = new GameController(List.of("car1", "car2", "car3"), 0);

        // when
        OutputView.printGame(gameController);

        // then
        String expectedOutput =
                "최종 우승자 : [car1, car2, car3]\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}