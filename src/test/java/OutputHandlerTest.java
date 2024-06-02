import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputHandlerTest {
    @Test
    @DisplayName("출력 형식이 올바른지")
    public void testFowardOutputOneWinner() {
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 2));
        cars.add(new Car("car3", 0));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        OutputHandler.fowardOutput(cars);

        System.setOut(originalOut);
        System.out.println(outContent.toString());

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "car1 : -" + lineSeparator +
            "car2 : --" + lineSeparator +
            "car3 : " + lineSeparator +
            lineSeparator;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("우승자 출력 테스트, 우승자가 한 명일 때")
    public void testWinnerOutputOneWinner() {
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 1));
        cars.add(new Car("car3", 2));
        cars.add(new Car("car4", 0));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        OutputHandler.winnerOutput(cars);

        System.setOut(originalOut);

        String lineSeparator = System.lineSeparator();

        String expectedOutput = "최종 우승자 : car3" + lineSeparator;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("우승자 출력 테스트, 우승자가 여러 명일 때")
    public void testWinnerOutputMultipleWinner() {
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 2));
        cars.add(new Car("car3", 2));
        cars.add(new Car("car4", 0));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        OutputHandler.winnerOutput(cars);

        System.setOut(originalOut);

        String lineSeparator = System.lineSeparator();

        String expectedOutput = "최종 우승자 : car2, car3" + lineSeparator;

        assertEquals(expectedOutput, outContent.toString());
    }
}
