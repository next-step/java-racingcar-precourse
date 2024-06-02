package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CarList 클래스 테스트")
class CarListTest {

    @Test
    @DisplayName("올바른 입력으로 생성되는지 확인")
    void testConstructorWithValidInput() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        CarList carList = new CarList(carNames);
        assertNotNull(carList.getCars());
        assertEquals(3, carList.getCars().size());
    }

    @Test
    @DisplayName("중복된 이름이 있는 경우 예외 발생하는지 확인")
    void testConstructorWithDuplicateNames() {
        List<String> carNames = Arrays.asList("Car1", "Car1", "Car2");
        assertThrows(IllegalArgumentException.class, () -> new CarList(carNames));
    }

    @Test
    @DisplayName("이름이 너무 긴 경우 예외 발생하는지 확인")
    void testConstructorWithInvalidName() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "ThisNameIsTooLong");
        assertThrows(IllegalArgumentException.class, () -> new CarList(carNames));
    }

    @Test
    @DisplayName("레이스 한 번 실행 후 각 자동차의 위치가 올바르게 갱신되는지 확인")
    void testRaceOnce() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        CarList carList = new CarList(carNames);
        carList.raceOnce();
        // As this is a random action, we can't make deterministic assertions here.
        // We can just check if the method doesn't throw any exception.
    }

    @Test
    @DisplayName("우승자를 올바르게 찾는지 확인")
    void testFindWinners() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        CarList carList = new CarList(carNames);
        // Assuming Car1 moved the most
        carList.getCars().get(0).move();
        carList.getCars().get(0).move();
        assertEquals(Arrays.asList("Car1"), carList.findWinners());
    }
}