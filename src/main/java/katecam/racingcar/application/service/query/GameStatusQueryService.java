package katecam.racingcar.application.service.query;


import java.util.List;
import katecam.racingcar.application.dto.query.CarPositionRes;
import katecam.racingcar.application.dto.query.GameTotalResultRes;
import katecam.racingcar.application.dto.query.GameTurnResultRes;
import katecam.racingcar.application.port.in.query.GameStatusQuery;
import katecam.racingcar.application.port.out.GameRecordPort;
import katecam.racingcar.domain.Car;
import katecam.racingcar.domain.Game;

public class GameStatusQueryService implements GameStatusQuery {
    private final GameRecordPort gameRecordPort;

    public GameStatusQueryService(GameRecordPort gameRecordPort) {
        this.gameRecordPort = gameRecordPort;
    }

    @Override
    public boolean isEnded() {
        Game game = gameRecordPort.getOrThrow();
        return game.isEnded();
    }

    @Override
    public GameTurnResultRes getTurnResult() {
        Game game = gameRecordPort.getOrThrow();
        List<CarPositionRes> carPositions= game.getCars().stream()
                 .map(car->new CarPositionRes(car.getName(), car.getPosition()))
                 .toList();
        return new GameTurnResultRes(carPositions);
    }

    @Override
    public GameTotalResultRes getTotalResult() {
        Game game = gameRecordPort.getOrThrow();
        List<String> winnerNames = game.getWinners().stream()
                .map(Car::getName)
                .toList();
        return new GameTotalResultRes(winnerNames);
    }
}
