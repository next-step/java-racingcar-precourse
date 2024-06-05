package view;

import model.CarGroup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void 실행_결과_메시지_출력_테스트() {
        // given
        String expectedOutput = "실행 결과\n";

        // when
        outputView.printExecutionResultMessage();

        // then
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void 진행_상황_출력_테스트_우승자() {
        // given
        CarGroup carGroup = new CarGroup(new String[]{"Car1", "Car2"}, 1);
        carGroup.getCars().get(0).moveFront(5);
        carGroup.getCars().get(1).moveFront(3);
        String expectedOutput = "\nCar1 : -\nCar2 : \n";

        // when
        outputView.printProgress(carGroup);

        // then
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void 결과_출력_테스트_우승자_2명() {
        // given
        CarGroup carGroup = new CarGroup(new String[]{"Car1", "Car2"}, 5);
        carGroup.getCars().get(0).moveFront(5);
        carGroup.getCars().get(1).moveFront(5);
        String expectedOutput = "최종 우승자 : Car1, Car2\n";

        // when
        outputView.printResult(carGroup);

        // then
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void 결과_출력_테스트_우승자_1명() {
        // given
        CarGroup carGroup = new CarGroup(new String[]{"Car1", "Car2"}, 5);
        carGroup.getCars().get(0).moveFront(5);
        carGroup.getCars().get(1).moveFront(3);
        String expectedOutput = "최종 우승자 : Car1\n";

        // when
        outputView.printResult(carGroup);

        // then
        assertEquals(expectedOutput, outContent.toString());
    }
}
