package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.model.car.CarCollection;
import racingcar.model.game.Board;
import racingcar.model.game.Count;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class BoardTest {

    private static MockedStatic<Randoms> mock;

    @BeforeAll
    public static void init() {
        mock = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void close() {
        mock.close();
    }

    @Test
    @DisplayName("생성자메소드에서 자동차컬렉션객체가 null이면 예외발생")
    void throw_NullPointException_when_null() {
        //given
        CarCollection carCollection = null;

        //when,then
        assertThatThrownBy(() -> new Board(carCollection, new Count("5")))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("[ERROR] 자동차컬렉션이 존재하지 않습니다");
    }

    @Test
    @DisplayName("winner메소드는 run메소드가 호출되기전에 호출되면 예외발생")
    void throw_IllegalStateException_when_before_run_method_is_called() {
        //given
        Board racingCarCollection = new Board(CarCollection.create("a,b,c"), new Count("5"));

        //when,then
        assertThatThrownBy(() -> racingCarCollection.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 게임이 끝나야 확인할 수 있습니다");
    }

    @Test
    @DisplayName("getWinner메소드는 position값높은 자동차리스트를 반환 ")
    void returns_racingcars_with_max_position() {
        //given
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(5, Arrays.stream(new Integer[]{1, 2, 3, 7, 1}).toArray());
        Board board = new Board(CarCollection.create("a,b,c"), new Count("2"));

        //when
        board.run();

        //then
        assertThat(board.getWinners().size()).isEqualTo(2);
    }


    @Test
    @DisplayName("getTryCount메소드는 시도횟수 반환 ")
    void returns_try_count() {
        //given
        CarCollection carCollection = CarCollection.create("a,b,c");
        Count count = new Count("3");

        //when
        Board board = new Board(carCollection, count);

        //then
        assertThat(board.getTryCount()).isEqualTo(3);
    }


}
