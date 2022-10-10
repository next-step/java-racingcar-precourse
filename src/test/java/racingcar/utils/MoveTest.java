package racingcar.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entities.Car;
import racingcar.entities.NamesInput;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static racingcar.utils.StringHandlerTest.INPUT_STRING_TRUE_CASE;

public class MoveTest {
    private static Move move;
    private static ArrayList<Car> cars;

    @BeforeAll
    static void beforeAll() {
        move = new Move();
        INPUT_STRING_TRUE_CASE = new NamesInput("pobi,crong,honux");
        cars = INPUT_STRING_TRUE_CASE.constructCars();
    }

    @DisplayName("값이 주어질 때 전진여부 결정하는 기능 테스트")
    @Test
    void isCarMoveTest() {
        assertThat(move.isCarMove(3)).isFalse();
        assertThat(move.isCarMove(8)).isTrue();
    }


    @DisplayName("랜덤값이 주어질 때 올바른 값이 주어지는지 여부 테스트")
    @Test
    void validateRandomMoveNumberTest() {

        int randomNumber = move.getRandomNumber(0, 9);
        assertThat(randomNumber >= 0 && randomNumber <= 9).isTrue();
    }


    @DisplayName("한 횟수가 끝난 뒤 location이 변경되는지 여부 테스트")
    @Test
    void addLocationTest() {

        cars.get(0).proceedGameOnce();
        assumingThat(cars.get(0).getRandomNumber() >= 4, () -> {
            System.out.println("randomnumber : " + cars.get(0).getRandomNumber() + "자동차는 움직여야합니다");
            assertThat(cars.get(0).getDistance() == 1).isTrue();
        });
        assumingThat(cars.get(0).getRandomNumber() < 4, () -> {
            System.out.println("randomnumber : " + cars.get(0).getRandomNumber() + "자동차는 움직이지 않습니다");
            assertThat(cars.get(0).getDistance() == 0).isTrue();
        });

    }

}
