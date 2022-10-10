package racingcar.domain.car;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.car.vo.Round;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;

class CarRaceTrackTest {

    private final MovePolicy movePolicy = () -> true;
    private final Name pobi = new Name("pobi");
    private final Position zeroPosition = Position.zero();
    private final Car car = new Car(pobi, zeroPosition);
    private final Cars cars = new Cars(new ArrayList<>(asList(car)));

    @Test
    void 인스턴스가_생성된다() {
        assertThatCode(() -> new CarRaceTrack(movePolicy, cars, History.empty()))
            .doesNotThrowAnyException();
    }

    @Test
    void 경기를_진행한다() {
        final CarRaceTrack beforeTrack = new CarRaceTrack(movePolicy, cars, History.empty());

        final Round round = new Round(1);
        final CarRaceTrack afterTrack = beforeTrack.round(round);

        final Car car = new Car(pobi, zeroPosition.increase());
        final Cars cars = new Cars(new ArrayList<>(asList(car)));
        final CarRaceTrack expectedTrack = new CarRaceTrack(movePolicy, cars, History.empty().add(cars));

        assertThat(afterTrack).isEqualTo(expectedTrack);
    }
}