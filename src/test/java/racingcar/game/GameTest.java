package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.game.car.Car;
import racingcar.game.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameTest {
    static final int MOVING_FORWARD = 4;
    static final int STOP = 3;

    static final Cars cars = new Cars(new Car("x"), new Car("y"));

    @Test
    @DisplayName("process() Cars=2,Turn=3의 경우, 2개의 차가 들어있는 3개의 GameState")
    void process_2Cars3Turns_SizeOfGameStatesIs3AndWhichSizeOfCarsIs2() {
        GameStates states = Game.process(cars, new IntRange(3));

        assertThat(states.size()).isEqualTo(3);
        assertThat(states.get(0).getCars().get(0).getName().get()).isEqualTo("x");
        assertThat(states.get(0).getCars().get(1).getName().get()).isEqualTo("y");
        assertThat(states.get(1).getCars().get(0).getName().get()).isEqualTo("x");
        assertThat(states.get(1).getCars().get(1).getName().get()).isEqualTo("y");
    }

    @Test
    @DisplayName("winningCars() X는 전진, Y는 정지일 때, 이동거리가 X는 1, Y는 0")
    void process_2Cars1Turns_MoveXAndStopY_DistanceOfXIs1AndDistanceOfYIs0() {
        GameStates states;
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD, STOP);

            states = Game.process(cars, new IntRange(1));
        }

        assertThat(states.size()).isEqualTo(1);
        assertThat(states.get(0).getCars().get(0).getDistance().get()).isEqualTo(1);
        assertThat(states.get(0).getCars().get(1).getDistance().get()).isEqualTo(0);
    }

    @Test
    @DisplayName("winningCars() 2대 중 2대 모두 승리")
    void winningCars_XAndYWins() {
        GameStates states;
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD);

            states = Game.process(cars, new IntRange(1));
        }

        Cars winningCars = Game.winningCars(states.get(0).getCars());

        assertThat(states.size()).isEqualTo(1);
        assertThat(winningCars.size()).isEqualTo(2);
        assertThat(winningCars.get(0).getName().get()).isEqualTo("x");
        assertThat(winningCars.get(1).getName().get()).isEqualTo("y");
    }

    @Test
    @DisplayName("winningCars() 2대 중 1대 승리")
    void winningCars_XWins() {
        GameStates states;
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD, STOP);

            states = Game.process(cars, new IntRange(1));
        }

        Cars winningCars = Game.winningCars(states.get(0).getCars());

        assertThat(states.size()).isEqualTo(1);
        assertThat(winningCars.size()).isEqualTo(1);
        assertThat(winningCars.get(0).getName().get()).isEqualTo("x");
    }
}
