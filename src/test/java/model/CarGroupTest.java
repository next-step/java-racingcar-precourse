package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarGroupTest {

    private CarGroup carGroup;
    private String[] carNames = {"Car1", "Car2", "Car3"};
    private int tryCount = 5;

    @BeforeEach
    public void setUp() {
        carGroup = new CarGroup(carNames, tryCount);
    }

    @Test
    public void 초기화_테스트() {
        // given
        String[] expectedCarNames = carNames;

        // when
        List<Car> cars = carGroup.getCars();

        // then
        assertEquals(expectedCarNames.length, cars.size(), "자동차의 수는 자동차 이름 배열의 길이와 같아야 한다.");
        for (int i = 0; i < expectedCarNames.length; i++) {
            assertEquals(expectedCarNames[i], cars.get(i).getName(), "자동차 이름은 제공된 이름과 일치해야 한다.");
        }
    }

    @Test
    public void 종료_여부_테스트() {
        // given
        int movesNeeded = tryCount;

        // when & then
        for (int i = 0; i < movesNeeded; i++) {
            assertFalse(carGroup.isEnded(), "이동 횟수에 도달하기 전에는 isEnded가 false여야 한다.");
            carGroup.move();
        }
        assertTrue(carGroup.isEnded(), "이동 횟수에 도달한 후에는 isEnded가 true여야 한다.");
    }
}
