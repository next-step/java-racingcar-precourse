package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.RacingCarRepository;
import repository.RacingCarRepositoryImpl;
import repository.RacingCarRoundRepository;

import java.util.Arrays;
import repository.RacingCarRoundRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    private RacingCarRepository racingCarRepository;
    private RacingCarRoundRepository racingCarRoundRepository;
    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarRepository = new RacingCarRepositoryImpl();
        racingCarRoundRepository = new RacingCarRoundRepositoryImpl();
        racingCarService = new RacingCarService(racingCarRepository, racingCarRoundRepository);
    }

    @Test
    @DisplayName("createRacingCar 메서드 테스트")
    void createRacingCarTest() {

        // given
        RacingCarCommand.Create createCommand = new RacingCarCommand.Create(
            Arrays.asList("Car1", "Car2"));

        // when
        racingCarService.createRacingCar(createCommand);

        // then
        assertThat(racingCarRepository.findAll()).hasSize(2);
    }

    @Test
    @DisplayName("playRacing 메서드 테스트")
    void playRacingTest() {

        // given
        RacingCarCommand.Create createCommand = new RacingCarCommand.Create(
            Arrays.asList("Car1", "Car2"));
        racingCarService.createRacingCar(createCommand);

        RacingCarCommand.RacingRound racingRound = new RacingCarCommand.RacingRound("3");

        // when
        racingCarService.playRacing(racingRound);

        // then
        assertThat(racingCarRoundRepository.findAll()).hasSize(3);
    }

    @Test
    @DisplayName("getGameResult 메서드 테스트")
    void getGameResultTest() {

        // given
        RacingCarCommand.Create createCommand = new RacingCarCommand.Create(
            Arrays.asList("Car1", "Car2"));
        racingCarService.createRacingCar(createCommand);

        RacingCarCommand.RacingRound racingRound = new RacingCarCommand.RacingRound("3");
        racingCarService.playRacing(racingRound);

        // when
        RacingCarModel.GameResult gameResult = racingCarService.getGameResult();

        // then
        assertThat(gameResult.racingCarRounds()).hasSize(3);
    }

}
