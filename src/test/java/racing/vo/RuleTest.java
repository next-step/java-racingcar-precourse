package racing.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuleTest {

    @Test
    @DisplayName("자동차경주 이동횟수 입력 에러 ")
    public void setRacingRoundFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Rule rule = new Rule("-1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rule rule = new Rule("0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rule rule = new Rule("AB-");
        });
    }

    @Test
    @DisplayName("자동차경주 경기횟수 저장")
    public void setRacingRound(){
        String round = "5";
        Rule rule = new Rule(round);
    }

}
