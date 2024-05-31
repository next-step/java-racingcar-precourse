package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        // Cars 객체를 생성하고 차량을 초기화합니다.
        cars = new Cars(List.of("차1", "차2", "차3"));
    }

    @Test
    void size_차량의_개수를_반환합니다() {
        // 차량의 개수가 올바르게 반환되는지 확인합니다.
        assertEquals(3, cars.size());
    }

    @Test
    void get_인덱스에_해당하는_차량을_반환합니다() {
        // 인덱스에 해당하는 차량이 올바르게 반환되는지 확인합니다.
        assertEquals("차1", cars.get(0).carName());
    }
}