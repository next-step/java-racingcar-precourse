package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceTest {

    @RepeatedTest(20)
    @DisplayName("랜덤 수 생성 주사위가 지정한 최솟값과 최댓값 사이의 값만을 반환하는지 테스트")
    public void dice_ShouldReturn_LessThanMin_GreaterThanMax() {
        //when
        Dice dice = Dice.roll();
        //then
        assertThat(dice.getTicks()).isLessThanOrEqualTo(Dice.MAX_VALUE).isGreaterThanOrEqualTo(Dice.MIN_VALUE);
    }
}
