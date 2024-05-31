import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class testRacingCar {
    @Test
    public void testCheckNameValid() {
        RacingCar racingCar = new RacingCar();
        assertDoesNotThrow(() -> racingCar.checkName("abc"));
    }

    @Test
    public void testCheckNameInvalid() {
        RacingCar racingCar = new RacingCar();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> racingCar.checkName("abcdef"));
        assertEquals("[ERROR] 이름 길이가 적절하지 않습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> racingCar.checkName(""));
        assertEquals("[ERROR] 이름 길이가 적절하지 않습니다.", exception.getMessage());
    }

    @Test
    public void testInputName() {
        RacingCar racingCar = new RacingCar();
        String input = "car1,car2,car3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingCar.inputName();
        assertArrayEquals(new String[]{"car1", "car2", "car3"}, racingCar.nameList);
    }

    @Test
    public void testCheckNumValid() {
        RacingCar racingCar = new RacingCar();
        assertDoesNotThrow(() -> racingCar.checkNum(5));
    }

    @Test
    public void testCheckNumInvalid() {
        RacingCar racingCar = new RacingCar();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> racingCar.checkNum(0));
        assertEquals("[ERROR] 0보다 큰 숫자를 입력해 주세요.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> racingCar.checkNum(-1));
        assertEquals("[ERROR] 0보다 큰 숫자를 입력해 주세요.", exception.getMessage());
    }
    @Test
    public void testInputTryNum() {
        RacingCar racingCar = new RacingCar();
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingCar.inputTryNum();
        assertEquals(3, racingCar.tryNum);
    }
    @Test
    public void testOneStep() {
        RacingCar racingCar = new RacingCar();
        racingCar.nameList = new String[]{"car1", "car2", "car3"};
        racingCar.stepList = new int[]{0, 0, 0};
        racingCar.oneStep();
        assertTrue(racingCar.maxNum >= 0 && racingCar.maxNum <= 1);
    }

    
}
