package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnersTest {

    @Test
    void 생성() {
        List<Car> cars = Collections.singletonList(new Car("abc"));
        assertEquals(new Winners(cars), new Winners(cars));
    }

    @Test
    void 이름_반환() {
        List<Car> cars = Arrays.asList(new Car("abc"), new Car("def"));
        Winners winners = new Winners(cars);
        assertEquals(winners.names(), Arrays.asList("abc", "def"));
    }
}