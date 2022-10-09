package racingcar.model.cars;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import racingcar.model.cars.factory.Engine;
import racingcar.model.cars.factory.MoveEvent;
import racingcar.model.cars.factory.MoveHistory;
import racingcar.model.cars.factory.Title;

public class CarTest {
    @Test
    void 자동차_작동하면_엔진_히스토리_작동() {
        Engine engine = mock(Engine.class);
        MoveHistory moveHistory = mock(MoveHistory.class);
        MoveEvent moveEvent = mock(MoveEvent.class);
        when(engine.run()).thenReturn(moveEvent);
        doNothing().when(moveHistory).add(moveEvent);

        new Car(mock(Title.class), engine, moveHistory).move();

        verify(engine, only()).run();
        verify(moveHistory, only()).add(moveEvent);
    }
}
