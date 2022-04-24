package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("pobi,woni,jun");
    }

    @Test
    @DisplayName("레이싱 공동 우승자 얻기")
    void co_victor() {
        String result = "pobi,jun";

        cars.moveForward(Arrays.asList(9, 0, 9));
        Victors victors = cars.getVictors();
        assertThat(victors.toString()).hasToString(result);
    }

    @Test
    @DisplayName("레이싱 단독 우승자 얻기")
    void single_victor() {
        String result = "pobi";

        cars.moveForward(Arrays.asList(9, 0, 0));
        Victors victors = cars.getVictors();
        assertThat(victors.toString()).hasToString(result);
    }

    @Test
    @DisplayName("자동차 이름 중복 실패")
    void duplicate_name_failed() {
        String duplicatedNames = "pobi,woni,jun,pobi";

        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없다.");
    }

    @Test
    @DisplayName("pobi와 jun 전진, woni와 jun 전진")
    void move_pobi_and_jun_move_woni_jun() {
        String result = "pobi : -" + "\n" +
                "woni : -" + "\n" +
                "jun : --" + "\n";

        cars.moveForward(Arrays.asList(9, 0, 9));
        MoveResult moveResult = cars.moveForward(Arrays.asList(0, 9, 9));
        assertThat(moveResult.toString()).hasToString(result);
    }

    @Test
    @DisplayName("pobi와 jun 전진")
    void move_pobi_and_jun() {
        String result = "pobi : -" + "\n" +
                "woni : " + "\n" +
                "jun : -" + "\n";

        MoveResult moveResult = cars.moveForward(Arrays.asList(9, 0, 9));
        assertThat(moveResult.toString()).hasToString(result);
    }

    @Test
    @DisplayName("woni와 jun 전진")
    void move_woni_and_jun() {
        String result = "pobi : " + "\n" +
                "woni : -" + "\n" +
                "jun : -" + "\n";


        MoveResult moveResult = cars.moveForward(Arrays.asList(0, 9, 9));
        assertThat(moveResult.toString()).hasToString(result);
    }
}
