import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Random;
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

    @Test
    @DisplayName("순위별로 차량이 올바르게 정렬 되는가?")
    void testForward() {
        RacingGame.racingCar.add(new Car("c1"));
        RacingGame.racingCar.add(new Car("c2"));
        RacingGame.racingCar.add(new Car("c3"));
        RacingGame.racingCar.add(new Car("c4"));
        RacingGame.racingCar.add(new Car("c5"));
        RacingGame.racingCar.add(new Car("c6"));
        for(int i=0; i<10; i++)
            RacingGame.racing();
        RacingGame.lineUp();
        for(int i=0; i<RacingGame.racingCar.size()-1; i++) {
            assertTrue(RacingGame.racingCar.get(i).getPosition().length() >= RacingGame.racingCar.get(i+1).getPosition().length());
        }
    }
}
