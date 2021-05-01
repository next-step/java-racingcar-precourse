package com.github.momentjin.core.application;

import com.github.momentjin.core.model.Location;
import com.github.momentjin.core.model.MovableObject;
import com.github.momentjin.mock.MockLocation;
import com.github.momentjin.mock.MockMovableObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MaxPositionExtractionServiceTest {

    @DisplayName("Max Location을 가진 movable 객체를 추출할 수 있다")
    @Test
    void extract() {

        // given
        Location location1 = new MockLocation(1);
        Location location2 = new MockLocation(2);
        Location location3 = new MockLocation(3);
        Location maxLocation = getMaxLocation(location1, location2, location3);

        List<MovableObject> movableObjects = Arrays.asList(
                new MockMovableObject(location1),
                new MockMovableObject(location2),
                new MockMovableObject(location3),
                new MockMovableObject(location3)
        );

        // when
        List<MovableObject> movablesHasMaxLocation = new MaxPositionExtractionService()
                .extract(movableObjects);

        // then
        assertThat(movablesHasMaxLocation)
                .allMatch(o -> o.getLocation().equals(maxLocation));
    }

    @DisplayName("input이 비어있으면 IllegalArgumentException이 발생한다")
    @Test
    void extract2() {

        // given
        List<MovableObject> empty = Collections.emptyList();

        // when & then
        assertThatThrownBy(() -> new MaxPositionExtractionService().extract(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있는 리스트는 허용하지 않습니다");
    }

    private Location getMaxLocation(Location... location) {

        List<Location> locations = Arrays.asList(location);
        Collections.sort(locations);

        return locations.get(locations.size() - 1);
    }
}
