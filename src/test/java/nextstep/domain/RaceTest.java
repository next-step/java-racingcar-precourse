package nextstep.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race("pobi,crong,honux");
    }

    @Test
    void 경주_시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 3, 4);
            List<MoveResult> results = race.move();
            assertThat(results).contains(
                    new MoveResult("pobi",1),
                    new MoveResult("crong", 0),
                    new MoveResult("honux", 1));
        }
    }

    @Test
    void 결과_반환() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 3, 4);
            race.move();
            RaceResult result = race.result();
            assertThat(result).isEqualTo(new RaceResult("pobi,honux"));
        }
    }
}