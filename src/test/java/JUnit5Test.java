import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit5Test {

    private ArrayList<Car> carList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carList.add(new Car("a"));
        carList.add(new Car("b"));
    }

    @Test
    @DisplayName("randNum() 메서드가 0~9 사이 값을 반환하는가?")
    void testRandNumRange() {
        int num = RacingGame.randNum();
        assertTrue(num >= 0 && num <= 9);
    }
}
