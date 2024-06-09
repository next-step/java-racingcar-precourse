package katecam.racingcar.application.service;


import java.util.List;
import katecam.racingcar.application.dto.query.CarPositionRes;
import katecam.racingcar.application.dto.query.GameTotalResultRes;
import katecam.racingcar.application.dto.query.GameTurnResultRes;
import katecam.racingcar.application.port.in.query.GameStatusQuery;
import katecam.racingcar.application.port.out.GameLoadPort;
import katecam.racingcar.domain.Car;
import katecam.racingcar.domain.Game;

public class GameStatusQueryService implements GameStatusQuery {
    private final GameLoadPort gameLoadPort;

    public GameStatusQueryService(GameLoadPort gameLoadPort) {
        this.gameLoadPort = gameLoadPort;
    }

    @Override
    public boolean isEnded() {
        Game game = gameLoadPort.getOrThrow();
        return game.isEnded();
    }

    @Override
    public GameTurnResultRes getTurnResult() {
        Game game = gameLoadPort.getOrThrow();
        List<CarPositionRes> carPositions= game.getCars().stream()
                 .map(car->new CarPositionRes(car.getName(), car.getPosition()))
                 .toList();
        return new GameTurnResultRes(carPositions);
    }

    @Override
    public GameTotalResultRes getTotalResult() {
        Game game = gameLoadPort.getOrThrow();
        List<String> winnerNames = game.getWinners().stream()
                .map(Car::getName)
                .toList();
        return new GameTotalResultRes(winnerNames);
    }
}
