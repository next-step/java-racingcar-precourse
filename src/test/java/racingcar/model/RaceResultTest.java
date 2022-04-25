package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    @DisplayName("레이스 경주 결과 비교시 거리가 동일하면 동일하다고 판별한다.")
    void compare_same_distance() {
        RaceResult raceResult1 = new RaceResult("aaa", 3);
        RaceResult raceResult2 = new RaceResult("bbb", 3);
        assertThat(raceResult1.compareTo(raceResult2)).isEqualTo(0);
    }

    @Test
    @DisplayName("레이스 경주 결과 비교시 제일 먼저 거리 내림차순으로 비교한다.")
    void compare_diff_distance() {
        RaceResult raceResult1 = new RaceResult("aaa", 8);
        RaceResult raceResult2 = new RaceResult("bbb", 3);
        assertThat(raceResult1.compareTo(raceResult2)).isEqualTo(1);
    }

    @Test
    @DisplayName("이름을 리턴한다.")
    void return_name() {
        RaceResult raceResult = new RaceResult("aaa", 8);
        assertThat(raceResult.getCarName()).isEqualTo("aaa");
    }

    @Test
    @DisplayName("이동 거리를 리턴한다.")
    void return_distance() {
        RaceResult raceResult = new RaceResult("aaa", 8);
        assertThat(raceResult.getDistance()).isEqualTo(8);
    }

    @Test
    @DisplayName("레이스 경주 결과의 이름과 거리가 동일하면 동일하다.")
    void equals() {
        RaceResult raceResult1 = new RaceResult("aaa", 8);
        RaceResult raceResult2 = new RaceResult("aaa", 8);
        assertThat(raceResult1).isEqualTo(raceResult2);
    }
}
