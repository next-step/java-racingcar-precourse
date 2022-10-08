package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    @DisplayName("인스턴스 생성 시 초기 값 0 확인")
    public void 초기화_확인() {
        // given // when
        Distance distance = new Distance();

        // then
        assertThat(distance.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동거리 증가 테스트")
    public void 이동거리_증가() {
        // given
        Distance distance = new Distance();

        // when
        distance.increaseDistance();
        distance.increaseDistance();

        // then
        assertThat(distance.getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("이동거리 만큼 - 출력 테스트")
    public void 이동거리_출력_테스트() {
        // given
        Distance distance = new Distance();

        // when
        distance.increaseDistance();
        distance.increaseDistance();
        String printMessage = distance.getDistancePrintMessage();

        // then
        assertThat(printMessage).isEqualTo("--");
    }
}
