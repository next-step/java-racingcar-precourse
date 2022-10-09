package racingcar.model.progress;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.cars.Car;

public class ParticipantsTest {
    @Test
    void 자동차_목록_작동() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        Participants participants = Participants.of(Arrays.asList(car1, car2));

        participants.move();

        verify(car1, only()).move();
        verify(car2, only()).move();
    }
}
