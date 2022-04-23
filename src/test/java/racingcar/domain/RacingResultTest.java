package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import racingcar.application.port.out.FakeRacingCarAdapter;

class RacingResultTest {

    @Test
    void 결과_테스트() {
        FakeRacingCarAdapter adapter = new FakeRacingCarAdapter();
        RoundResult roundResult = new RoundResult(0, adapter.getRacingCars());

        RacingResult racingResult = new RacingResult(Stream.of(roundResult).collect(Collectors.toList()));

        assertEquals("a,b", racingResult.getWinners().stream().map(data -> data.getRacingCarName().getName()).collect(
                Collectors.joining(",")));

        assertEquals(2,
                racingResult.getWinners().stream().map(RacingCar::getMoveCount).distinct().findFirst().orElse(0));
    }

}