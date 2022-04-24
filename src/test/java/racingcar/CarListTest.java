package racingcar;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class CarListTest {
    private MockedStatic<Randoms> mock;

    @Test
    void 경주_시작_한명만진행() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 0, 9, 0, 0, 9, 0, 0, 9);

        int lap = 3;
        CarList carList = new CarList("apple, hoho, curry");
        Assertions.assertDoesNotThrow(() -> carList.race(lap));

        mock.close();
    }

    @Test
    void 경주_시작_두명진행() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 9, 9, 0, 9, 9, 9, 9, 9);

        int lap = 3;
        CarList carList = new CarList("apple, hoho, curry");
        Assertions.assertDoesNotThrow(() -> carList.race(lap));

        mock.close();
    }
}
