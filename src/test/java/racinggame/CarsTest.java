package racinggame;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars("a,b,c");
    }

    @Test
    void cars_a_전진() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4);
            cars.play();

            assertTrue(cars.getCars().get(0).isMovableForwardStatus());
            assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(1);
        }
    }

    @Test
    void cars_a_후퇴() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(0);
            cars.play();

            assertFalse(cars.getCars().get(0).isMovableForwardStatus());
            assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(0);
        }
    }

    @Test
    void cars_a_b_c_전진() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 5, 9);
            cars.play();

            assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(1);
            assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(1);
            assertThat(cars.getCars().get(2).getMoveCount()).isEqualTo(1);
        }
    }

    @Test
    void cars_a_b_c_후퇴() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 0);
            cars.play();

            assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(0);
            assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(0);
            assertThat(cars.getCars().get(2).getMoveCount()).isEqualTo(0);
        }
    }

    @Test
    void cars_a_b_전진_c_후퇴() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 5, 0);
            cars.play();

            assertThat(cars.getCars().get(0).getMoveCount()).isEqualTo(1);
            assertThat(cars.getCars().get(1).getMoveCount()).isEqualTo(1);
            assertThat(cars.getCars().get(2).getMoveCount()).isEqualTo(0);
        }
    }

    @Test
    void cars_이름_5자_이상_테스트2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Cars cars = new Cars("dsaklfjdsalkjf,fdkldsajfldkasj");
                }).withMessageContaining("5자를 초과");
    }
}
