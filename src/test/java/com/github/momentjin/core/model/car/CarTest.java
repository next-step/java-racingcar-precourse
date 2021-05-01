package com.github.momentjin.core.model.car;

import com.github.momentjin.core.model.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("moveForward를 호출하면 Location의 increaseOne 메소드가 1번 호출되어야 한다")
    public void moveForward() {

        // given
        String anyCarName = "자동차이름";
        MockLocation mockLocation = new MockLocation();
        Car car = new Car(anyCarName, mockLocation);

        // when
        car.moveForward();

        // then
        assertThat(mockLocation.getCountOfMethodCall())
                .isOne();
    }
}

class MockLocation implements Location {

    private int countOfMethodCall;

    @Override
    public Location increaseOne() {
        this.countOfMethodCall++;
        return this;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    public int getCountOfMethodCall() {
        return countOfMethodCall;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}