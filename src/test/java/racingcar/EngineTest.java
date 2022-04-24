package racingcar;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class EngineTest {
    @Test
    void 엔진_작동_테스트() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Engine engine = new Engine();
        Assertions.assertFalse(engine.isWorking());  //0
        Assertions.assertFalse(engine.isWorking());  //1
        Assertions.assertFalse(engine.isWorking());  //2
        Assertions.assertFalse(engine.isWorking());  //3
        Assertions.assertTrue(engine.isWorking());  //4
        Assertions.assertTrue(engine.isWorking());  //5
        Assertions.assertTrue(engine.isWorking());  //6
        Assertions.assertTrue(engine.isWorking());  //7
        Assertions.assertTrue(engine.isWorking());  //8
        Assertions.assertTrue(engine.isWorking());  //9

        mock.close();
    }
}
