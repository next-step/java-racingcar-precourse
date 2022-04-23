package racingcar.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.adapter.ephemeral.out.RacingCarAdapter;
import racingcar.application.port.in.PlayRacingCommand;
import racingcar.application.port.in.PlayRacingUsecase;
import racingcar.application.port.out.FakeRacingCarAdapter;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;

class PlayRacingServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 레이싱_테스트() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD, Stream.of(STOP, MOVING_FORWARD, STOP).toArray());

            RacingCarAdapter racingCarAdapter = new RacingCarAdapter();
            racingCarAdapter.save(new RacingCars(
                    Stream.of(new RacingCar(new RacingCarName("a")), new RacingCar(new RacingCarName("b")))
                            .collect(Collectors.toList())));

            PlayRacingUsecase playRacingUsecase = new PlayRacingService(racingCarAdapter);
            RacingResult racingResult = playRacingUsecase.playRacing(new PlayRacingCommand("2"));

            assertAll(() -> assertEquals("a",
                            racingResult.getWinners().stream().map(data -> data.getRacingCarName().getName()).findFirst()
                                    .orElse("")),
                    () -> assertEquals("a : -\n" + "b : \n\n", racingResult.getRoundResultList().get(0).toString()),
                    () -> assertEquals("a : --\n" + "b : \n\n", racingResult.getRoundResultList().get(1).toString()));

        }

    }
}