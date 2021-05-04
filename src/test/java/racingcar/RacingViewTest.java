package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingViewTest {

    @DisplayName("사용자 입력 View 기능")
    @Test
    static void inputViewTest() {
        RacingView racingView = new RacingView();
        racingView.getRacingInfo();

        assertThat(racingView.getCars().length).isEqualTo(3);
        assertThat(racingView.getEventCount()).isEqualTo(5);

    }


    public static void main(String[] args) {
        inputViewTest();
    }
}
