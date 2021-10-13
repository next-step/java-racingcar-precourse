package domainTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.MoveCount;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCountTest {

    @Test
    @DisplayName("랜덤 값이 4일 때 moveCount 증가")
    public void increaseCountValueFour(){
        MoveCount moveCount = new MoveCount();
        moveCount.judgeMove(4);

        assertThat(moveCount.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3일 때 moveCount 정지")
    public void stopCountValueThree(){
        MoveCount moveCount = new MoveCount();
        moveCount.judgeMove(3);

        assertThat(moveCount.getMoveCount()).isEqualTo(0);
    }

}
