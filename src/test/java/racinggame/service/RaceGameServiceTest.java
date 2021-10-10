package racinggame.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.RaceFinishResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceGameServiceTest {

    List<String> carNames = new ArrayList<>();

    @BeforeEach
    void before() {
        carNames.add("1번");
        carNames.add("2번");
        carNames.add("3번");
        carNames.add("4번");
    }

    @Test
    public void 레이스_서비스_1회실행() throws Exception{
        RaceGameService raceGameService = new RaceGameService();
        RaceFinishResult raceFinishResult = raceGameService.startRace(carNames, 5);
        assertThat(raceFinishResult.getRaceRounds().size()).isEqualTo(5);
    }


}