package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    Cars cars;
    @BeforeEach
    void createCars() {
        cars = CarsFactory.create("ssa,mz,ag");
    }

    @Test
    @DisplayName("차이름을 중복 입력하면 예외가 발생한다")
    void duplicatedCarNameException() {
        assertThatThrownBy(() -> CarsFactory.create("ssam,ssam"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 중복되었습니다.");
    }


}
