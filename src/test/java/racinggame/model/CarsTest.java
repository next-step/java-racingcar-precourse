package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.enums.Error;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Cars: 자동차 경주 게임을 하는 Car 들의 묶음")
public class CarsTest {

    @DisplayName("자동차들은 처음에 전부 0 위치에 있음")
    @Test
    void testInitCars() {
        Cars cars = new Cars(Arrays.asList("alice", "bob", "cook"));

        MoveResults results = cars.getResult();

        assertThat(results.getOutput()).contains("alice : ");
        assertThat(results.getOutput()).contains("bob : ");
        assertThat(results.getOutput()).contains("cook : ");
    }

    @DisplayName("moveAll() 메소드로 넘겨준 숫자의 크기와 자동차 갯수가 일치하지 않으면 에러")
    @Test
    void testMoveAllInvalid() {
        Cars cars = new Cars(Arrays.asList("alice", "bob", "cook"));

        cars.moveAll(Arrays.asList(4, 3, 5));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cars.moveAll(Arrays.asList(1, 2)))
                .withMessage(Error.INVALID_MOVE_NUMBER_SIZE.message());
    }

    @DisplayName("넘겨준 숫자 순서대로 이동함")
    @Test
    void testMoveAll() {
        Cars cars = new Cars(Arrays.asList("alice", "bob", "cook"));

        cars.moveAll(Arrays.asList(4, 3, 5));
        MoveResults results = cars.getResult();

        assertThat(results.getOutput()).contains("alice : -");
        assertThat(results.getOutput()).contains("bob : ");
        assertThat(results.getOutput()).contains("cook : -");
    }
}
