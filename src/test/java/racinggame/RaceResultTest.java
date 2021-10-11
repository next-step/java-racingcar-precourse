package racinggame;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RaceResultTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars(Arrays.asList("a", "b", "c"));
    }

    @AfterEach
    void beforeEnd() {
        RaceManager.deleteInstance();
    }

    @Test
    void 게임_끝() {
        RaceManager raceManager = RaceManager.createInstance("3");

        for (int i=0; i<3; i++) {
            raceManager.process();
            RaceResult raceResult = cars.play();
        }

        assertThat(raceManager.isGameEnd()).isEqualTo(true);
    }

    @Test
    void 게임_진행_중() {
        RaceManager raceManager = RaceManager.createInstance("3");
        raceManager.process();
        RaceResult raceResult = cars.play();

        assertThat(raceManager.isGameEnd()).isEqualTo(false);
    }

    @Test
    void 게임_a_b_승리() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 4, 0);
            RaceManager raceManager = RaceManager.createInstance("1");
            raceManager.process();
            RaceResult raceResult = cars.play();
            String expectResult = "a,b";

            assertThat(raceResult.toString()).contains(expectResult);
        }
    }

    @Test
    void 게임_a_b_승리_진행_3턴() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 4, 0, 4, 9, 1, 5, 6, 2);
            RaceManager raceManager = RaceManager.createInstance("3");
            RaceResult raceResult = null;
            for (int i=0; i<3; i++) {
                raceManager.process();
                raceResult = cars.play();
                System.out.println(raceResult.toString());
            }
            String expectResult = "a,b";

            assertThat(raceResult.toString()).contains(expectResult);
        }
    }
}
