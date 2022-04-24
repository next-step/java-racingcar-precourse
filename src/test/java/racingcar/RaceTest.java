package racingcar;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RaceTest {
    private static final String MAX_INTEGER_STRING = String.valueOf(Integer.MIN_VALUE);
    private static final String LAP_COUNT_STRING = "3";

    private MockedStatic<Randoms> mock;

    @Test
    void 자동차_등록성공() {
        Race race = new Race();
        Assertions.assertDoesNotThrow(() -> race.setCarList("app, bob, curry"));
        Assertions.assertDoesNotThrow(() -> race.setCarList("app,bob,curry"));
    }

    @Test
    void 자동차_등록실패() {
        Race race = new Race();
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setCarList("appapp, bob, curry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setCarList("app,bob,,curry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setCarList("app,bob,cu ry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setCarList(null));
    }

    @Test
    void 자동차_정상등록() {
        Race race = new Race();
        Assertions.assertDoesNotThrow(() -> race.setCarList("app, bob, curry"));
    }

    @Test
    void 전진횟수_등록_성공() {
        Race race = new Race();
        Assertions.assertDoesNotThrow(() -> race.setLap("1"));
        Assertions.assertDoesNotThrow(() -> race.setLap(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    void 전진횟수_등록_실패() {
        Race race = new Race();
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setLap("0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setLap(MAX_INTEGER_STRING));
    }

    @Test
    void 경주진행_한명만진행() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 0, 9, 0, 0, 9, 0, 0, 9);

        Race race = new Race();
        race.setCarList("apple, hoho, curry");
        race.setLap(LAP_COUNT_STRING);

        Assertions.assertDoesNotThrow(race::race);

        mock.close();
    }

    @Test
    void 경주진행_두명진행() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 9, 9, 0, 9, 9, 9, 9, 9);

        Race race = new Race();
        race.setCarList("apple, hoho, curry");
        race.setLap(LAP_COUNT_STRING);

        Assertions.assertDoesNotThrow(race::race);

        mock.close();
    }

    @Test
    void 경주조건_실패_차가없음() {
        Race race = new Race();
        race.setLap(LAP_COUNT_STRING);

        Assertions.assertThrows(IllegalStateException.class, race::race);
    }

    @Test
    void 경주조건_실패_전진횟수0() {
        Race race = new Race();
        race.setLap(LAP_COUNT_STRING);

        Assertions.assertThrows(IllegalStateException.class, race::race);
    }

    @Test
    void 레이스결과_단일우승자() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 0, 9, 0, 0, 9, 0, 0, 9);

        Race race = new Race();
        race.setCarList("apple, hoho, curry");
        race.setLap(LAP_COUNT_STRING);
        race.race();

        Assertions.assertEquals("curry", race.getWinner().get(0).getName());

        mock.close();
    }

    @Test
    void 레이스결과_공동우승자() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 9, 9, 0, 9, 9, 0, 9, 9);

        Race race = new Race();
        race.setCarList("apple, hoho, curry");
        race.setLap(LAP_COUNT_STRING);
        race.race();

        Assertions.assertEquals("hoho", race.getWinner().get(0).getName());
        Assertions.assertEquals("curry", race.getWinner().get(1).getName());

        mock.close();
    }
}
