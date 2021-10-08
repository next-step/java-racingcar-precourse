package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("abcd");
    }

    @Test
    void 생성확인() {
        assertThat(car.getName()).isEqualTo("abcd");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름이_5글자_이상인_경우_에러발생_확인() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("abcdef"))
                .withMessageContaining("[ERROR]");
    }

    @Test
    void 이동_조건을_만족했을_때_이동하는지_확인() {
        assertRandomTest(() -> {
            car.tryRace();
            assertThat(car.getPosition()).isEqualTo(1);
        }, 4);
    }

    @Test
    void 이동_조건을_만족하지_못했을_때_이동하지_않았는지_확인() {
        assertRandomTest(() -> {
            car.tryRace();
            assertThat(car.getPosition()).isEqualTo(0);
        }, 3);
    }

    private void assertRandomTest(final Executable executable, final int thenResult) {
        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(thenResult);
            executable.execute();
        } catch (Throwable throwable) {
            fail(throwable.getMessage());
        }
    }
}