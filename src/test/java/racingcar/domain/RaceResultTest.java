package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {

    private RaceResult raceResult;

    @BeforeEach
    void setup() {
        raceResult = new RaceResult();
    }

    @Test
    void 추월당하면_패배자() {
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.LOSE);
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        Assertions.assertThat(raceResult.isWinner()).isFalse();
    }

    @Test
    void 추월당하지않으면_승리자() {
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        raceResult.report(RaceStatus.WINNE);
        Assertions.assertThat(raceResult.isWinner()).isTrue();
    }

}