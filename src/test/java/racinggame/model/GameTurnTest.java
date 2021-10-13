package racinggame.model;

import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.vo.PlayerName;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameTurnTest {
    Cars cars;

    @BeforeEach
    void setup(){
        this.cars = new Cars();

        this.cars.add(new Car(new PlayerName("car1"), new CarLocation(0)));
        this.cars.add(new Car(new PlayerName("car2"), new CarLocation(0)));
        this.cars.add(new Car(new PlayerName("car3"), new CarLocation(0)));
    }

    @Test
    void 한_턴의_게임이_진행되면_모든_자동차의_전진_시도를_수행한다(){
        Assertions.assertThat(new GameTurn().run(this.cars).size()).isEqualTo(this.cars.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 한_턴의_게임동안_생성되는_모든_랜덤값이_3_이하일_경우_모든_자동차는_전진하지_않는다(int generatedRandomValue){
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(new GameTurn().run(this.cars)).containsOnly(RANDOM_MOVE_RESULT.STAY);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 한_턴의_게임동안_생성되는_모든_랜덤값이_4_이상일_경우_모든_자동차는_전진한다(int generatedRandomValue){
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(new GameTurn().run(this.cars)).containsOnly(RANDOM_MOVE_RESULT.FORWARD);
        }
    }
}
