package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void 생성() {
        assertEquals(new Car("abc"), new Car("abc"));
    }

    @Test
    void 이름_검증() {
        String name = "abc";
        Car car = new Car(name);
        assertEquals(car.getName(), Name.of(name));
    }

    @Test
    void 생성시에는_거리가_0이다() {
        Car car = new Car("abc");
        assertEquals(car.getDistance(), Distance.of(0));
    }

    @Test
    void 전진() {
        Car car = new Car("abc");
        car.move(() -> true);
        assertEquals(car.getDistance(), Distance.of(1));
    }

    @Test
    void 정지() {
        Car car = new Car("abc");
        car.move(() -> false);
        assertEquals(car.getDistance(), Distance.of(0));
    }
}