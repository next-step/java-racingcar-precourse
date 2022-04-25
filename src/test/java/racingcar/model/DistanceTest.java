package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest {
    @DisplayName("Distance 값 증가 테스트")
    @Test
    void matchIncreaseValue() {
        Distance distance = new Distance();

        for(int i=0; i< 2; i++) {
            distance.increase();
        }

        assertEquals(2, distance.getDistanceValue());
    }

    @DisplayName("Distance 출력 테스트")
    @Test
    void matchDistancePrint() {
        Distance distance = new Distance();

        for(int i=0; i< 5; i++) {
            distance.increase();
        }

        assertEquals("-----", distance.toStringDistanceShape());
    }

    @DisplayName("Distance 값 비교 테스트")
    @Test
    void returnPositiveIntegerWhenCompareToLessThanTheDistance() {
        Distance aDistance = new Distance();
        Distance bDistance = new Distance();

        aDistance.increase();

        assertEquals(1, aDistance.compareTo(bDistance));
    }
}
