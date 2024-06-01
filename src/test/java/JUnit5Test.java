import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit5Test {
    @BeforeEach
    void setUp() {
        RacingGame.racingCar.add(new Car("c1"));
        RacingGame.racingCar.add(new Car("c2"));
        RacingGame.racingCar.add(new Car("c3"));
        RacingGame.racingCar.add(new Car("c4"));
        RacingGame.racingCar.add(new Car("c5"));
        RacingGame.racingCar.add(new Car("c6"));
        for(int i=0; i<10; i++)
            RacingGame.racing();
        RacingGame.lineUp();
    }

    @Test
    @DisplayName("자동차 이름의 중복을 확인하는가?")
    void testCarNameDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> RacingController.carVerify(new String[]{"c1", "c1"}));
    }

    @Test
    @DisplayName("randNum() 메서드가 0~9 사이 값을 반환하는가?")
    void testRandNumRange() {
        int num = RacingGame.randNum();
        for(int i=0; i<1000; i++)
            assertTrue(num >= 0 && num <= 9);
    }

    @Test
    @DisplayName("순위별로 차량이 올바르게 정렬 되는가?")
    void testLanking() {
        for(int i=0; i<RacingGame.racingCar.size()-1; i++) {
            assertTrue(RacingGame.racingCar.get(i).getPosition().length() >= RacingGame.racingCar.get(i+1).getPosition().length());
        }
    }

    @Test
    @DisplayName("우승 차량이 올바르게 선정 되는가?")
    void testResult() {
        Car winner = new Car("1st");
        RacingGame.racingCar.add(winner);
        RacingGame.racingCar.add(new Car("c7"));
        for(int i=0; i<11; i++)
            winner.forward();
        RacingGame.lineUp();
        assertEquals(0, RacingGame.winner());
        assertEquals(winner.getName(), RacingGame.racingCar.get(RacingGame.winner()).getName());
    }

    @AfterEach
    void clean() {
        RacingGame.racingCar.clear();
    }
}
