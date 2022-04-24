package racingcar.racing;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.DisplayedParameterizedTest;
import racingcar.car.Car;

public class RacingTest {

    static private List<Car> cars;
    static private Car kiaCar;
    static private Car hyundaiCar;

    private Racing racing;

    @BeforeAll
    static void before() {
        kiaCar = new Car("kia");
        hyundaiCar = new Car("현대");
        cars = asList(kiaCar, hyundaiCar);
    }

    @BeforeEach
    void beforeEach() {
        List<RacingLine> spiedRacingLines = asList(
                spy(new RacingLine(kiaCar)),
                spy(new RacingLine(hyundaiCar))
        );
        racing = new Racing(spiedRacingLines, 1);
    }

    @Test
    void cars_로_레이싱_생성_테스트() {
        int maxRacingRound = 10;

        Racing racing = Racing.fromCars(cars, 10);

        assertThat(racing.getMaxRacingRound()).isEqualTo(maxRacingRound);
        assertThat(racing.getRacingLines())
                .extracting("racingCar")
                .containsExactly(kiaCar, hyundaiCar);
    }

    @DisplayedParameterizedTest
    @MethodSource("레이싱_생성_예외_케이스")
    void cars_로_레이싱_생성_예외_테스트(List<Car> cars, int maxRacingRound, String errorMessage) {
        assertThatThrownBy(() -> Racing.fromCars(cars, maxRacingRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    static List<Arguments> 레이싱_생성_예외_케이스() {
        return asList(
                Arguments.of(null, 1, "레이싱을 생성하기 위한 자동차 리스트가 null 입니다"),
                Arguments.of(emptyList(), 1, "레이싱을 위해서는 1대 이상의 자동차가 필요합니다"),
                Arguments.of(cars, 0, "레이싱은 1 회 이상 진행해야합니다")
        );
    }

    @Test
    void 레이싱을_진행하면_모든_레이싱라인이_goStraight_한다() {
        racing.play();

        for (RacingLine racingLine : racing.racingLines) {
            verify(racingLine).goStraight();
        }
    }

    @Test
    void 레이싱이_이미_종료된_경우_play_예외가_발생하고_이후_goStraight_하지않는다() {
        racing.play();

        assertThatThrownBy(racing::play)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 종료된 레이싱입니다");
        for (RacingLine racingLine : racing.racingLines) {
            verify(racingLine).goStraight();
        }
    }

    @Test
    void 레이싱_최대_횟수만큼_play_하면_isGameEnd_true() {
        assertThat(racing.isRacingEnd()).isFalse();

        racing.play();
        assertThat(racing.isRacingEnd()).isTrue();
    }

    @Test
    void 단독_선두_가져오기_테스트() {
        when(racing.racingLines.get(0).getPosition()).thenReturn(1);
        when(racing.racingLines.get(1).getPosition()).thenReturn(0);

        Set<Car> firstCars = racing.getFirstCars();

        assertThat(firstCars)
                .contains(racing.racingLines.get(0).getRacingCar());
    }

    @Test
    void 선두_가져오기_테스트() {
        when(racing.racingLines.get(0).getPosition()).thenReturn(1);
        when(racing.racingLines.get(1).getPosition()).thenReturn(1);

        Set<Car> firstCars = racing.getFirstCars();

        assertThat(firstCars)
                .contains(racing.racingLines.get(0).getRacingCar(), racing.racingLines.get(1).getRacingCar());
    }
}
