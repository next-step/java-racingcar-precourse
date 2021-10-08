package racinggame.game;

import org.junit.jupiter.api.Test;
import racinggame.domain.RacingGame;
import racinggame.domain.RacingResult;
import racinggame.domain.TryTimes;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {

    @Test
    public void 입력받은_이름수만큼_차가_생성되어야함(){
        RacingGame racingGame = RacingGame.from("abc,bcd,efg");
        assertEquals(racingGame.getCarCount(), 3);
    }

    @Test
    public void 입력한_수만큼_전진이_반복되어야함(){
        int n = 5;
        RacingGame racingGame = RacingGame.from("abc,bcd,efg");
        RacingResult racingResult = racingGame.startNTimes(new TryTimes(n));
        assertEquals(racingResult.resultSize(), n);
    }

}
