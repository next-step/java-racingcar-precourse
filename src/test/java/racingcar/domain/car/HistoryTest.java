package racingcar.domain.car;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;

class HistoryTest {

    @Test
    void 기록이_추가된다() {
        History history = History.empty()
            .add(new Cars(new ArrayList<>(asList(
                new Car(new Name("pobi"), new Position(0)),
                new Car(new Name("crong"), new Position(0)),
                new Car(new Name("honux"), new Position(0))
            ))));

        assertThat(history.cars()).hasSize(1);
    }
}
