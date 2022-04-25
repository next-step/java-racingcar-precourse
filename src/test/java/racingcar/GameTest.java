package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 라운드_입력_예외_처리_통과(){
        Game game2 = new Game(1);
    }

}