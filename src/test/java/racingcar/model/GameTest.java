package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static MockedStatic<Randoms> randoms;
    private static MockedStatic.Verification verification = () -> Randoms.pickNumberInRange(anyInt(), anyInt());
    private static OutputStream captor;
    private static PrintStream standardOut;

    @BeforeAll
    static void before() {
        randoms = mockStatic(Randoms.class);
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterAll
    public static void after() {
        randoms.close();
        System.setOut(standardOut);
        System.out.println(output());
    }

    private static String output() {
        return captor.toString().trim();
    }

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
        list.add(new Car("pobi"));
        list.add(new Car("nobi"));
        list.add(new Car("dobi"));
        Game game = new Game("1", list);
        randoms.when(verification).thenReturn(MOVING_FORWARD, STOP, MOVING_FORWARD);
        // when
        game.start();
        // then
        assertThat(output()).contains("pobi : -", "nobi : ", "dobi : -");
    }

    @Test
    void 게임우승자_세팅_확인_테스트() {
        // given
        List<Car> list = new ArrayList<>();
        list.add(new Car("pobi"));
        list.add(new Car("nobi"));
        list.add(new Car("dobi"));
        Game game = new Game("1", list);
        list.remove(1);
        // when
        game.setWinnerList(list);
        // then
        assertThat(game.getWinnerList().getCarByIndex(0).getCarName()).isEqualTo("pobi");
        assertThat(game.getWinnerList().getCarByIndex(1).getCarName()).isEqualTo("dobi");
    }

    @Test
    void 게임우승자_START메서드활용_확인_테스트() {
        // given
        List<Car> list = new ArrayList<>();
        list.add(new Car("pobi"));
        list.add(new Car("nobi"));
        list.add(new Car("dobi"));
        Game game = new Game("1", list);
        randoms.when(verification).thenReturn(MOVING_FORWARD, STOP, MOVING_FORWARD);
        // when
        game.start();
        // then
        assertThat(game.getWinnerList().getCarByIndex(0).getCarName()).isEqualTo("pobi");
        assertThat(game.getWinnerList().getCarByIndex(1).getCarName()).isEqualTo("dobi");
        assertThat(output()).contains("최종 우승자: pobi, dobi");
    }
}
