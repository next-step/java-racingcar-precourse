package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이동조건 도메인 테스트")
class MoveConditionTest {

    @DisplayName("이동조건에 따라 이동거리 생성")
    @RepeatedTest(50)
    void 이동조건에_따라_이동거리_생성() {
        // given
        ArrayList<Distance> distances = 유효한_이동거리_목록_생성();

        // when + then
        assertThat(MoveCondition.getDistance()).isIn(distances);
    }

    private ArrayList<Distance> 유효한_이동거리_목록_생성() {
        ArrayList<Distance> distances = new ArrayList<>();
        distances.add(new Distance(0));
        for (int i = 4; i <= 9; i++) {
            distances.add(new Distance(i));
        }
        assertThat(distances.size()).isEqualTo(7);
        return distances;
    }
}