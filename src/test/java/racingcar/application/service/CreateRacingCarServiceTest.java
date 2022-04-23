package racingcar.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.adapter.ephemeral.out.RacingCarAdapter;
import racingcar.application.port.in.CreateRacingCarCommand;
import racingcar.application.port.in.CreateRacingCarUsecase;

class CreateRacingCarServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"a,b", "a,b,c", "a"})
    void 경주용_자동차_생성(String input) {
        RacingCarAdapter adapter = new RacingCarAdapter();
        CreateRacingCarUsecase createRacingCarUsecase = new CreateRacingCarService(adapter);

        createRacingCarUsecase.create(new CreateRacingCarCommand(input));

        assertFalse(adapter.getRacingCars().getSortedRacingCars().isEmpty());

    }

}