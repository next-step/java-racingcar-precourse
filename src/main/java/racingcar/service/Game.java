package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.GameHistory;
import racingcar.domain.Names;
import racingcar.domain.dto.GameHistoryDto;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.service.dto.GameInformation;

public class Game {

    private final Integer time;
    private final Names names;
    private final MoveStrategy moveStrategy;

    private Game(Names names, Integer time, MoveStrategy moveStrategy) {
        this.time = time;
        this.names = names;
        this.moveStrategy = moveStrategy;
    }

    public static Game of(GameInformation gameInformation, MoveStrategy moveStrategy) {
        return new Game(gameInformation.getNames(), gameInformation.getTime(), moveStrategy);
    }

    public GameHistoryDto start() {
        GameHistory gameHistory = new GameHistory();
        Cars cars = makeCars(names);

        //시작하기 전 상태 저장
        gameHistory.save(cars);

        for (int now = 0; now < this.time; now++) {
            cars = step(cars);
            gameHistory.save(cars);
        }

        gameHistory.makeWinner(time);
        return GameHistoryDto.from(gameHistory);
    }

    private Cars makeCars(Names names) {
        return Cars.from(names.defaultPositionCars());
    }

    private Cars step(Cars cars) {
        return cars.move(moveStrategy);
    }
}

