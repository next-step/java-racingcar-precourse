package com.github.momentjin;

import com.github.momentjin.car.Car;
import com.github.momentjin.car.CarLocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MaxPositionExtractorTest {

    @DisplayName("Max Location을 가진 movable 객체를 추출할 수 있다")
    @Test
    void extract() {

        // given
        Location maxLocation = new CarLocation(3);
        List<MovableObject> movableObjects = Arrays.asList(
                new Car("자동차1", new CarLocation(1)),
                new Car("자동차2", new CarLocation(2)),
                new Car("자동차3", maxLocation),
                new Car("자동차4", maxLocation)
        );

        // when
        List<MovableObject> movablesHasMaxLocation = new MaxPositionExtractor()
                .extract(movableObjects);

        // then
        assertThat(movablesHasMaxLocation)
                .allMatch(o -> o.getLocation().equals(maxLocation));
    }

    @DisplayName("input이 비어있으면 IllegalArgumentException이 발생한")
    @Test
    void extract2() {

        // given
        List<MovableObject> empty = Collections.emptyList();

        // when & then
        assertThatThrownBy(() -> new MaxPositionExtractor().extract(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있는 리스트는 허용하지 않습니다");
    }
}