package katecam.racingcar.application;

import java.util.List;
import katecam.racingcar.adapter.out.InMemoryGameAdaptor;
import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.service.GameInitializationService;
import katecam.racingcar.application.service.GameTurnPlayService;
import katecam.racingcar.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTurnPlayServiceTest {
    private final int NUMBER_TO_ATTEMPT = 5;
    private GameTurnPlayService service;
    private Game game;

    @BeforeEach
    void setUp() {
        InMemoryGameAdaptor inMemoryGameAdaptor = new InMemoryGameAdaptor();
        service = new GameTurnPlayService(inMemoryGameAdaptor);

        List<String> carNames = List.of("sdfasdf","asdfasfd","xcvsdqeg");
        GameInitializationReq req = new GameInitializationReq(carNames, NUMBER_TO_ATTEMPT);
        GameInitializationService initializationService = new GameInitializationService(
                inMemoryGameAdaptor);
        initializationService.initialize(req);

        game = inMemoryGameAdaptor.getOrThrow();
    }

    @Test
    void 플레이턴_테스트() {
        service.playTurn();

        Assertions.assertEquals(1, game.getAttemptedNumber());
    }

    @Test
    void 게임끝날때까지돌리기(){
        for (int i = 0; i < NUMBER_TO_ATTEMPT; i++) {
            service.playTurn();
        }

        Assertions.assertTrue(game.isEnded());

    }
}
