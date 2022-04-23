package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.common.PositiveNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {
    private final int MOVE = 4;
    private final int STOP = 3;

    @Test
    void 레이싱_게임에_참가할_이름을_COMMA_로_구분하여_생성할_수_있다() {
        Racing racing = new Racing("abc,def,ghi");

        assertThat(racing.participantCount()).isEqualTo(3);
    }

    @Test
    void 레이싱_게임_참여자는_2명_이상이어야_한다() {
        assertThatThrownBy(() -> new Racing("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing("abc")).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 레이싱_게임은_입력된_횟수를_진행하면_최종_우승자가_정해진다() {
        assertRandomNumberInRangeTest(
            () -> {
                Racing racing = new Racing("abc,def,ghi");

                racing.play(new PositiveNumber(4));

                List<Car> winners = racing.getWinners();
                assertThat(winners.size()).isEqualTo(1);

                for (Car winner: winners) {
                    assertThat(winner.getName()).isEqualTo("ghi");
                }
            },
                STOP, MOVE, STOP,
                MOVE, MOVE, MOVE,
                STOP, STOP, MOVE,
                STOP, STOP, MOVE
        );
    }
}