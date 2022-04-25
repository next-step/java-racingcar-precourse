package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022/04/22 11:16 오전
 */
@DisplayName("Domain:Player")
public class PlayerTest {

    @Test
    @DisplayName("게임에 참여할 자동차 이름과 진행할 라운드 수 입력")
    public void inputJoiningCarName() {
        // Given
        String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
        int roundCount = 5;

        String[] split = namesByComma.split(",");

        // When
        Player player = Player.of(namesByComma, roundCount);

        // Then
        assertThat(player.getCarNames()).size().isEqualTo(split.length);
        assertThat(player.getTotalRound()).isEqualTo(roundCount);
        for (int i = 0; i < split.length; i++) {
            assertThat(player.getCarNames().get(i)).isEqualTo(split[i]);
        }
    }
}
