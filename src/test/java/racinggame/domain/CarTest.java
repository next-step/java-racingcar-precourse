package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    public static final String NAME = "abc";

    @Test
    void 생성() {
        assertEquals(new Car(NAME), new Car(NAME));
    }

    @Test
    void 이름_검증() {
        Car car = new Car(NAME);
        assertEquals(car.getName(), Name.of(NAME));
    }

    @Test
    void 생성시에는_거리가_0이다() {
        Car car = new Car(NAME);
        assertEquals(car.getDistance(), Distance.of(0));
    }

    @Test
    void 전진() {
        Car car = new Car(NAME);
        car.move(() -> true);
        assertEquals(car.getDistance(), Distance.of(1));
    }

    @Test
    void 정지() {
        Car car = new Car(NAME);
        car.move(() -> false);
        assertEquals(car.getDistance(), Distance.of(0));
    }
}