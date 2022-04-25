package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {
    @Test
    @DisplayName("5자 이하의 이름을 가진 레이싱카를 생성한다")
    void 다섯자_이하의_이름을_가진_레이싱카를_생성한다() {
        String name = "alpha";
        RacingCar racingCar = new RacingCar(name);
        assertThat(racingCar.getName()).isEqualTo(name);
    }
    @Test
    @DisplayName(("5자 이상의 이름을 설정하면 오류를 발생시킨다"))
    void 다섯자_이상의_이름을_설정하면_오류를_발생시킨다() {
        assertThatThrownBy(() -> {
            String name = "foxtrot";
            RacingCar racingCar = new RacingCar(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName(("빈 이름을 설정하면 오류를 발생시킨다"))
    void 빈_이름을_설정하면_오류를_발생시킨다() {
        assertThatThrownBy(() -> {
            String name = "";
            RacingCar racingCar = new RacingCar(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("4이상 값을 받으면 한칸 전진한다")
    void 사이상_값을_받으면_한칸_전진한다() {
        String name = "alpha";
        RacingCar racingCar = new RacingCar(name);
        int currentProgress = racingCar.getRaceProgress();
        racingCar.race(5);
        assertThat(racingCar.getRaceProgress()).isEqualTo(currentProgress + 1);
    }
    @Test
    @DisplayName("3이하 값을 받으면 전진하지 않는다")
    void 삼이하_값을_받으면_전진하지_않는다() {
        String name = "alpha";
        RacingCar racingCar = new RacingCar(name);
        int currentProgress = racingCar.getRaceProgress();
        racingCar.race(3);
        assertThat(racingCar.getRaceProgress()).isEqualTo(currentProgress);
    }
}