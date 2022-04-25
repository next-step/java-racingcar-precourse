package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.RandomMovement;

class RaceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    public void 레이스_횟수가_0또는_음수이면_오류를_반환한다(int input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Race(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 레이스_횟수만큼_게임이_진행된_후_상태값은_True이다(int raceCount) {
        // given
        Race race = new Race(raceCount);

        // when
        for (int i = 0; i < raceCount; i++) {
            race.raceStart();
        }

        // then
        assertThat(race.isRaceFinish()).isTrue();
    }

    @Test
    public void 레이스_결과로_우승자를_반환한다() {
        // given
        Cars cars = new Cars(Arrays.asList("pobi", "jason", "mins"));
        Race race = new Race(5);

        // when
        for (int i = 0; i < 5; i++) {
            race.raceStart();
            cars.moveResult(new RandomMovement());
        }

        // then
        assertThat(race.raceResult(cars).size()).isGreaterThan(0);
    }
}