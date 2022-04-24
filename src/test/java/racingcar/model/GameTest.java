package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {
    @Test
    void 입력받은_횟수로_세팅여부_테스트() {
        // given
        // when
        Game game = new Game("1");
        // then
        assertThat(game.getNumberOfExecutions()).isEqualTo(1);
    }

    @Test
    void 입력받은_횟수_검증_테스트_에러발생() {
        // given
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game("5st12"));
    }

    @Test
    void 입력받은_CarList_정상등록_확인() {
        // given
        List<Car> list = new ArrayList<>();
        list.add(new Car("car1"));
        list.add(new Car("car2"));
        // when
//        game.setCarList(list);
        Game game = new Game("2", list);
        // then
        assertThat(game.getCarList().getCarByIndex(0).getCarName()).isEqualTo("car1");
        assertThat(game.getCarList().getCarByIndex(1).getCarName()).isEqualTo("car2");
    }

    @Test
    void 게임수행과정_출력_테스트() {
        // given
        List<Car> list = new ArrayList<>();
        list.add(new Car("car1"));
        list.add(new Car("car2"));
        Game game = new Game("2", list);
        // when

        // then
    }

    @Test
    void 게임수행결과_출력_테스트() {
        // given

        // when

        // then
    }
}
