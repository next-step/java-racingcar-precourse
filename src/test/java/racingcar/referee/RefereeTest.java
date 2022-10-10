package racingcar.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.domain.Car;
import racingcar.car.domain.CarName;
import racingcar.car.domain.CarPosition;
import racingcar.referee.domain.MovingNumber;
import racingcar.referee.domain.RacingCars;
import racingcar.referee.domain.Referee;
import racingcar.referee.domain.WinningCars;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("심판")
class RefereeTest {

    @DisplayName("차수 진행")
    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void createReferee(int number) {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car(new CarName("람보르기니"), new CarPosition()));
        racingCars.add(new Car(new CarName("페라리"), new CarPosition()));
        Referee referee = new Referee(racingCars, new MovingNumber(number));
        referee.playRound();
        assertThat(referee.movingNumber()).isEqualTo(new MovingNumber(number - 1));
    }

    @DisplayName("이동 횟수가 0이 될떄까지 차수를 진행한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void play(int number) {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car(new CarName("람보르기니"), new CarPosition()));
        racingCars.add(new Car(new CarName("페라리"), new CarPosition()));
        Referee referee = new Referee(racingCars, new MovingNumber(number));
        referee.playAllRound();
        assertThat(referee.movingNumber()).isEqualTo(new MovingNumber(0));
    }

    @DisplayName("우승 자동차")
    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void winningCars(int number) {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car(new CarName("람보르기니"), new CarPosition(4)));
        racingCars.add(new Car(new CarName("페라리"), new CarPosition(3)));
        Referee referee = new Referee(racingCars, new MovingNumber(number));
        WinningCars winningCars = referee.declareWinningCars();
        assertThat(winningCars.size()).isEqualTo(1);
        assertThat(winningCars.cars()).contains(new Car(new CarName("람보르기니"), new CarPosition(4)));
    }
}
