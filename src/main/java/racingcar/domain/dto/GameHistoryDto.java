package racingcar.domain.dto;

import racingcar.domain.Cars;
import racingcar.domain.GameHistory;

import java.util.ArrayList;
import java.util.List;

public class GameHistoryDto {
    private final List<CarsDto> history;
    private final Winners winners;

    private GameHistoryDto(List<CarsDto> history, Winners winners) {
        this.history = history;
        this.winners = winners;
    }

    public static GameHistoryDto from(GameHistory gameHistory) {
        List<CarsDto> carsDtoList = new ArrayList<>();
        for (Cars cars : gameHistory.getHistory()) {
            carsDtoList.add(CarsDto.from(cars));
        }
        Winners winners = Winners.from(gameHistory.getWinnerNames());
        return new GameHistoryDto(carsDtoList, winners);
    }

    public List<CarsDto> getHistory() {
        return history;
    }

    public Winners getWinners() {
        return winners;
    }
}
