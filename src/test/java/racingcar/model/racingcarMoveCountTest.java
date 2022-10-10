package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class racingcarMoveCountTest {
    @Test
    void 이동_수_입출력_테스트(){
        racingcarMoveCount moveCount = new racingcarMoveCount("5");
        assertThat(moveCount.getMoveCount()).isEqualTo("5");
    }
    @Test
    void 이동_수_입출력_숫자가_아닌_다른_문자가_들어올_경우(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new racingcarMoveCount("Ddshjak@!#");
        });

    }
}
