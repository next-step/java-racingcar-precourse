package racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarsTest {

    private RacingCars cars;

    @BeforeEach
    void setUp() {
        cars = new RacingCars(Arrays.asList("pobi", "crong", "honux"));
    }

    @DisplayName("자동차 이름 목록으로 자동차 일급컬렉션 객체를 생성할 수 있다.")
    @Test
    void create() {
    }

    @DisplayName("경주를 시작할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void race(final int n) {
        assertDoesNotThrow(
            () -> cars.race(n)
        );
    }
}
