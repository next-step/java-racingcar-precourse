package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;
    private Object Car;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("자동차 이름 목록을 특수문자로 각각 나누기 체크.")
    @Test
    void getDeviceValueTest() {
        cars = new Cars("a,b,c");

        assertThat(cars.getDeviceValue("a,c")).asList().contains("a");
    }
}