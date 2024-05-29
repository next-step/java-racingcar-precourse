import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.GameController;
import model.Trial;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialInputTest {

    GameController gameController;

    public TrialInputTest() {
        this.gameController = new GameController();
    }

    @Test
    void validTrial() {
        //1부터 100 사이의 값이 들어와야 한다.
        Assertions.assertThat(Trial.getTrial("1").getTrials()).isEqualTo(1);
        Assertions.assertThat(Trial.getTrial("50").getTrials()).isEqualTo(50);
        Assertions.assertThat(Trial.getTrial("100").getTrials()).isEqualTo(100);
    }

    @Test
    void inValidTrial() {
        //빈 입력
        assertThatThrownBy(
            () -> Trial.getTrial("")
        ).isInstanceOf(IllegalArgumentException.class);

        //정수 변환 불가
        assertThatThrownBy(
            () -> Trial.getTrial("string")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> Trial.getTrial("12a")
        ).isInstanceOf(IllegalArgumentException.class);

        // 중간에 공백 입력
        assertThatThrownBy(
            () -> Trial.getTrial("1 2")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> Trial.getTrial("12 ")
        ).isInstanceOf(IllegalArgumentException.class);

        // 범위 밖 입력
        assertThatThrownBy(
            () -> Trial.getTrial("0")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> Trial.getTrial("101")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> Trial.getTrial("-1")
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
