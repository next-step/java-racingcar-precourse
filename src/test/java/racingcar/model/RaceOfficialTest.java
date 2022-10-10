package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("model - RaceOfficial")
class RaceOfficialTest {
    private RaceOfficial raceOfficial;
    private GameErrors gameErrors;
    private RaceWinners raceWinners;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        raceOfficial = new RaceOfficial();
        raceWinners = new RaceWinners();
    }

    @DisplayName("라운드오피셔에 올바른 라운드가 선언되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {1, 50, 999})
    void set_rounds_test(int roundNumber) {
        // when
        raceOfficial.setRounds(String.valueOf(roundNumber), gameErrors);

        // Then
        assertThat(raceOfficial.rounds.getNumber()).isEqualTo(roundNumber);
    }

    @Test
    @DisplayName("특정 조건에 레이싱카를 이동시킬지 말지 결정하는 경우")
    void round_start_test() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("1", gameErrors);
        racingCars.add(new RacingCar("phobi"));

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                    assertThat( racingCars.get(0).getPosition() ).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("2라운드 - 특정 조건에 레이싱카를 이동시킬지 말지 결정하는 경우( 전진, 스톱 )")
    void race_start_test() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                    assertThat( racingCars.get(0).getPosition() ).isEqualTo(1);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("2라운드 - 특정 조건에 레이싱카를 이동시킬지 말지 결정하는 경우( 전진, 전진 )")
    void race_start_test2() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                    assertThat( racingCars.get(0).getPosition() ).isEqualTo(2);
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("2라운드 - 특정 조건에 레이싱카를 이동시킬지 말지 결정하는 경우( 스톱, 스톱 )")
    void race_start_test3() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                    assertThat( racingCars.get(0).getPosition() ).isEqualTo(0);
                },
                STOP, STOP
        );
    }

    @Test
    @DisplayName("2라운드 - 2명 특정 조건에 레이싱카를 이동시킬지 말지 결정하는 경우( 1. ( 전진, 스톱 ), 2. ( 전진, 전진 ) )")
    void race_start_test4() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));
        racingCars.add(new RacingCar("bio"));

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("2라운드 - 2명 우승자를 결정하는 경우 ( 1. ( 전진, 스톱 ), 2. ( 전진, 전진 ) )")
    void decide_race_winners_test() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));
        racingCars.add(new RacingCar("bio"));
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
        raceWinners = raceOfficial.decideRaceWinnders(racingCarCenter);

        // Then
        assertAll(
                () -> assertThat(raceWinners.getRaceWinnderPosition()).isEqualTo(2),
                () -> assertThat(raceWinners.getRaceWinners().size()).isEqualTo(1),
                () -> assertThat(raceWinners.getRaceWinners().get(0).getName()).isEqualTo("phobi")
        );
    }

    @Test
    @DisplayName("2라운드 - 공동 우승자를 결정하는 경우 ( 1. ( 전진, 전진 ), 2. ( 전진, 전진 ) )")
    void decide_race_winners_test2() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("2", gameErrors);
        racingCars.add(new RacingCar("phobi"));
        racingCars.add(new RacingCar("bio"));
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
        raceWinners = raceOfficial.decideRaceWinnders(racingCarCenter);

        // Then
        assertAll(
                () -> assertThat(raceWinners.getRaceWinnderPosition()).isEqualTo(2),
                () -> assertThat(raceWinners.getRaceWinners().size()).isEqualTo(2),
                () -> assertThat(raceWinners.getRaceWinners().get(0).getName()).isEqualTo("phobi"),
                () -> assertThat(raceWinners.getRaceWinners().get(1).getName()).isEqualTo("bio")
        );
    }

    @Test
    @DisplayName("3라운드 - 공동 우승자를 결정하는 경우 ( 1. ( 전진, 전진, 전진 ), 2. ( 스톱, 전진, 전진 ), 3. ( 전진, 전진, 전진 ) )")
    void decide_race_winners_test3() {
        // Given
        List<RacingCar> racingCars = new ArrayList<>();
        RacingCarCenter racingCarCenter = new RacingCarCenter(racingCars);

        // When
        raceOfficial.setRounds("3", gameErrors);
        racingCars.add(new RacingCar("phobi"));
        racingCars.add(new RacingCar("bio"));
        racingCars.add(new RacingCar("haru"));
        assertRandomNumberInRangeTest(
                () -> {
                    raceOfficial.raceStart(racingCarCenter);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
        raceWinners = raceOfficial.decideRaceWinnders(racingCarCenter);

        // Then
        assertAll(
                () -> assertThat(raceWinners.getRaceWinnderPosition()).isEqualTo(3),
                () -> assertThat(raceWinners.getRaceWinners().size()).isEqualTo(2),
                () -> assertThat(raceWinners.getRaceWinners().get(0).getName()).isEqualTo("phobi"),
                () -> assertThat(raceWinners.getRaceWinners().get(1).getName()).isEqualTo("haru")
        );
    }
}