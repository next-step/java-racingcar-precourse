package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RaceRoundTest {

    List<String> carNames = new ArrayList<>();

    @BeforeEach
    void before() {
        carNames.add("1번");
        carNames.add("2번");
        carNames.add("3번");
        carNames.add("4번");
    }

    @Test
    public void 레이스_라운드_생성() throws Exception{
        RaceGame raceGame = new RaceGame(carNames);
        List<RaceCar> run = raceGame.run();
        RaceRound raceRound = new RaceRound(run);

        assertThat(run.size()).isEqualTo(4);
        for (int i = 0; i < run.size(); i++) {
            assertThat(run.get(i)).isEqualTo(raceRound.getRaceCars().get(i));
        }
    }

    @Test
    public void 레이스_종료_생성() throws Exception{
        RaceGame raceGame = new RaceGame(carNames);
        List<RaceRound> raceRounds = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<RaceCar> raceRound = raceGame.run();
            raceRounds.add(new RaceRound(raceRound));
        }
        RaceFinishResult raceFinishResult = new RaceFinishResult(raceRounds);

        assertThat(raceFinishResult.getRaceRounds().size()).isEqualTo(5);
    }

}