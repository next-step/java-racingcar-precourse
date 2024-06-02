import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class InputHandlerTest {
    @Test
    @DisplayName("연달아서 입력할 때")
    public void testCarNameInputNoGap() throws IOException {
        String input = "car1,car2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vector<Car> cars = new Vector<>();
        InputHandler.CarNameInput(cars);

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());

        // Reset System.in to its original state
        System.setIn(System.in);
    }

    @Test
    @DisplayName("쉼표 이후에 공백이 있을 때")
    public void testCarNameInputGap() throws IOException {
        String input = "car1, car2, car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vector<Car> cars = new Vector<>();
        InputHandler.CarNameInput(cars);

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());

        // Reset System.in to its original state
        System.setIn(System.in);
    }

    @Test
    @DisplayName("시도할 횟수 입력 테스트")
    public void testAttemptCountInputPositive() throws IOException {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        int result = InputHandler.attemptCountInput();

        assertEquals(5, result);
    }

}
