import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class InputValidatorTest {
    @Test
    @DisplayName("유효한 이름일 때")
    public void testValidateCarNameWithValidNames() {
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 0));
        cars.add(new Car("car2", 0));
        cars.add(new Car("car3", 0));

        assertDoesNotThrow(() -> {
            assertTrue(InputValidator.validateCarName(cars));
        });
    }

    @Test
    @DisplayName("유효한 이름이 아닐 때")
    public void testValidateCarNameWithInvalidNames() {
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 0));
        cars.add(new Car("car123456", 0));  // Invalid name
        cars.add(new Car("car3", 0));

        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                InputValidator.validateCarName(cars);
            }
        });

        String expectedMessage = "[ERROR] : 자동차 이름의 글자 수는 5글자 이하만 가능합니다.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(0, cars.size()); // cars should be cleared
    }
}
