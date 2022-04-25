package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp(){
        this.car = new Car("K3",5);
    }
    @Test
    void 자동차전진값판단(){
        assertThat(car.goAndStop(1))
                .isEqualTo("");
    }
    @Test
    void 카객체에_결과값출력(){
        String result = car.result;
        assertThat(result).isNotEmpty();
    }
}