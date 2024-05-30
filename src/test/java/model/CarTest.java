package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("chunsik");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("난수가 4 미만일 때 전진 여부 테스트")
    void 정지_테스트(int number) {
        car.moveOrNot(number);
        assertEquals(0, car.getStep());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("난수가 4 이상일 때 전진 여부 테스트")
    void 전진_테스트(int number) {
        car.moveOrNot(number);
        assertEquals(1, car.getStep());
    }
}