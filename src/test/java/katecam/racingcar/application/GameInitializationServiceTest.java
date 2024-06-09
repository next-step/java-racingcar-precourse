package katecam.racingcar.application;

import java.util.List;
import katecam.racingcar.adapter.out.InMemoryGameAdaptor;
import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.service.GameInitializationService;
import katecam.racingcar.domain.Car;
import katecam.racingcar.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameInitializationServiceTest {
        private InMemoryGameAdaptor inMemoryGameAdaptor;
        private GameInitializationService service;

        @BeforeEach
        void setUp() {
            inMemoryGameAdaptor = new InMemoryGameAdaptor();
            service = new GameInitializationService(inMemoryGameAdaptor);
        }

        @Test
        void 초기화_테스트() {
            List<String> carNames = List.of("sdfasdf","asdfasfd","xcvsdqeg");
            GameInitializationReq req = new GameInitializationReq(carNames, 5);
            service.initialize(req);

            Game game = inMemoryGameAdaptor.getOrThrow();
            List<Car> cars = game.getCars();

            Assertions.assertEquals(cars.size(), carNames.size());
        }

}
