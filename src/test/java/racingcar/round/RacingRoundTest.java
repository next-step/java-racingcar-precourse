package racingcar.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.game.dto.RacingResult;
import racingcar.move.Movement;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingRoundTest {

    @Test
    @DisplayName("라운드 생성")
    public void create_round() {
        String round = "1";
        assertThatCode(() -> new RacingRound(round)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라운드 생성 실패(입력받은 라운드 수가 숫자가 아님)")
    public void failed_round() {
        String round = "아니다.";
        assertThatThrownBy(() -> new RacingRound(round)).isInstanceOf(IllegalArgumentException.class).hasMessage(RoundError.NOT_NUMBER.printMessage());
    }

    @Test
    @DisplayName("라운드 생성 실패(입력받은 라운드 수가 0이상이여야 한다.)")
    public void failed_round_0() {
        String round = "-1";
        assertThatThrownBy(() -> new RacingRound(round)).isInstanceOf(IllegalArgumentException.class).hasMessage(RoundError.NEGATIVE_NUMBER.printMessage());
    }

    @Test
    @DisplayName("라운드 시작")
    public void start_round() {
        Car car = new Car("java");
        RacingRound racingRound = new RacingRound("1");
        Movement movement = initMovement(true);
        List<RacingResult> racingResults = racingRound.start(Arrays.asList(car), movement);
        for (RacingResult result : racingResults) {
            assertThat(result.getName()).isEqualTo(car.getCarName().getName());
            assertThat(result.getPosition()).isEqualTo(car.getPosition().getPosition());
        }

    }

    @Test
    @DisplayName("라운드 시작 가능 여부(가능)")
    public void passible_round() {
        RacingRound racingRound = new RacingRound("1");
        assertThat(racingRound.possibleRoundStart()).isEqualTo(true);

    }

    private Movement initMovement(boolean isMove) {
        return new Movement() {
            @Override
            public boolean isMoveAble() {
                return isMove;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 1;
            }
        };
    }
}
