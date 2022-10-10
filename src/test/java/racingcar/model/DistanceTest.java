package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {
    @DisplayName("Distance 값 증가 테스트")
    @Test
    void distance_증가_테스트() {
        Distance distance = new Distance();

        for(int i=0; i< 2; i++) {
            distance.increase();
        }

        assertEquals(2, distance.getDistanceValue());
    }

    @DisplayName("Distance 출력 테스트")
    @Test
    void distance_출력_테스트() {
        Distance distance = new Distance();

        for(int i=0; i< 6; i++) {
            distance.increase();
        }

        assertEquals("------", distance.toStringDistanceShape());
    }

    @DisplayName("Distance 값 비교 테스트")
    @Test
    void distance_비교_테스트() {
        Distance distanceA = new Distance();
        Distance DistanceB = new Distance();

        distanceA.increase();

        assertEquals(1, distanceA.compareTo(DistanceB));
    }
}
