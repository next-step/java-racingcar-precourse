package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayCountRuleTest {
    @DisplayName("게임 횟수 규칙 생성에 성공한다.")
    @Test
    void createPlayCountRuleSuccess_P01() {
        PlayCountRule playCountRule = new PlayCountRule(0, 9);
        assertThat(playCountRule.getMinNum()).isEqualTo(0);
        assertThat(playCountRule.getMaxNum()).isEqualTo(9);
    }
}
