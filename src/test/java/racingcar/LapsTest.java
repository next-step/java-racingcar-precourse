package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LapsTest {
    @Test
    @DisplayName("Laps 생성 시 전달한 횟수가 보관되는지 검사한다")
    void getLapCountAfterCreation() {
        Laps laps = new Laps(5);

        assertThat(laps.getNumericLap()).isEqualTo(5);
    }

    @Test
    @DisplayName("다른 Laps와 같은 횟수로 값을 할당하는지 검사한다")
    void setLapCountFromOtherLaps() {
        Laps otherLaps = new Laps(5);
        Laps laps = new Laps();

        laps.setLaps(otherLaps);

        assertThat(laps.getNumericLap()).isEqualTo(otherLaps.getNumericLap());
    }

    @Test
    @DisplayName("Laps가 한 바퀴 감소하는지 검사한다")
    void decreaseLapsCount() {
        Laps laps = new Laps();

        laps.setNumericLap(5);
        laps.decrease();

        assertThat(laps.getNumericLap()).isEqualTo(4);
    }

    @Test
    @DisplayName("Laps가 0이면 더이상 감소하지 않는지 검사한다")
    void keepMinLapCountWheneverDecreasing() {
        Laps laps = new Laps(1);

        laps.decrease();
        laps.decrease();

        assertThat(laps.getNumericLap()).isEqualTo(Laps.MIN_LAP_COUNT);
    }

    @Test
    @DisplayName("Laps에 남은 이동 횟수가 없는지 검사한다")
    void hasRemainingLapCount() {
        Laps laps = new Laps();
        laps.setNumericLap(1);

        assertThat(laps.hasRemainingLaps()).isTrue();

        laps.decrease();

        assertThat(laps.hasRemainingLaps()).isFalse();
    }

    @Test
    @DisplayName("Laps 생성할 때 음수를 전달하면 예외를 발생하는지 검사한다")
    void throwIllegalArgumentExceptionIfCreationWithMinus() {
        assertThatThrownBy(() -> {
            Laps laps = new Laps(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Laps를 생성하고 음수를 할당하면 예외를 발생하는지 검사한다")
    void throwIllegalArgumentExceptionIfGoingToSetMinus() {
        Laps laps = new Laps();

        assertThatThrownBy(() -> {
            laps.setNumericLap(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
