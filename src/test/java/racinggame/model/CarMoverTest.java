package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import nextstep.utils.Randoms;
import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.vo.Car;
import racinggame.vo.CarLocation;
import racinggame.vo.PlayerName;

public class CarMoverTest {
    private CarMover carMover;

    @BeforeEach
    void setup() {
        this.carMover = new CarMover();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤값을_생성하여_4이상일_경우_Car_클래스가_이동한다(int generatedRandomValue) {
        int prevCarLocation = 0;

        Car car = new Car(new PlayerName("test"), new CarLocation(prevCarLocation));

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(this.carMover.moveRandomizly(car)).isEqualTo(RANDOM_MOVE_RESULT.FORWARD);
            Assertions.assertThat(car.getLocation()).isEqualTo(new CarLocation(prevCarLocation + 1));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤값을_생성하여_3이하일_경우_Car_클래스가_이동하지_않는다(int generatedRandomValue) {
        int prevCarLocation = 0;
        Car car = new Car(new PlayerName("test"), new CarLocation(prevCarLocation));

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(this.carMover.moveRandomizly(car)).isEqualTo(RANDOM_MOVE_RESULT.STAY);
            Assertions.assertThat(car.getLocation()).isEqualTo(new CarLocation(prevCarLocation));
        }
    }
}
