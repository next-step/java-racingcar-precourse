package racing.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuleTest {

    @Test
    @DisplayName("자동차경주 이동횟수 0 이하 입력 에러")
    public void setRacingRoundFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Rule rule = new Rule(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rule rule = new Rule(0);
        });
    }

    @Test
    @DisplayName("자동차경주 경기횟수 저장")
    public void setRacingRound(){
        int round = 5;
        Rule rule = new Rule(round);
    }

}
