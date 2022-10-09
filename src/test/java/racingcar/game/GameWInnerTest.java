package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.game.dto.WinnerResult;
import racingcar.move.Movement;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameWInnerTest {

    @Test
    @DisplayName("레이싱 게임 승자 계산(1명)")
    public void calculate_winner() {
        Car carOne = new Car("java");
        carOne.move(new Movement() {
            @Override
            public boolean isMoveAble() {
                return true;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 2;
            }
        });
        Car carTwo = new Car("c++");
        carTwo.move(new Movement() {
            @Override
            public boolean isMoveAble() {
                return true;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 3;
            }
        });

        List<Car> cars = Arrays.asList(carOne, carTwo);
        GameWinner gameWInner = new GameWinner();
        List<WinnerResult> winnerResult = gameWInner.selectWinner(cars);
        assertThat(winnerResult.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("레이싱 게임 승자 계산(1명)")
    public void calculate_2winner() {
        Car carOne = new Car("java");
        carOne.move(new Movement() {
            @Override
            public boolean isMoveAble() {
                return true;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 2;
            }
        });
        Car carTwo = new Car("c++");
        carTwo.move(new Movement() {
            @Override
            public boolean isMoveAble() {
                return true;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 2;
            }
        });

        List<Car> cars = Arrays.asList(carOne, carTwo);
        GameWinner gameWInner = new GameWinner();
        List<WinnerResult> winnerResult = gameWInner.selectWinner(cars);
        assertThat(winnerResult.size()).isEqualTo(2);
    }
}
