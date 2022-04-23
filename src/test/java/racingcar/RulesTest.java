package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.Rules.carNamingRule;
import static racingcar.utils.Rules.gameTryCountRule;

public class RulesTest {

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    public void car_name_validation() {
        assertThatThrownBy(() -> carNamingRule("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임횟수는 정수만 가능하다")
    public void game_count_validation() {
        assertThatThrownBy(() -> gameTryCountRule("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
