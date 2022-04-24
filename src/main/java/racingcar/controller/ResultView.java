package racingcar.controller;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.domain.dto.GameHistoryDto;
import racingcar.domain.dto.Winners;

import java.util.List;

public class ResultView {

    private static final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_CAR_FORMAT = "%s : %s";
    private static final String PRINT_RESULT_FORMAT = "최종 우승자: %s";

    private final GameHistoryDto gameHistoryDto;

    private ResultView(GameHistoryDto gameHistoryDto) {
        this.gameHistoryDto = gameHistoryDto;
    }

    public static ResultView from(GameHistoryDto gameHistoryDto) {
        return new ResultView(gameHistoryDto);
    }

    public void view() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        printHistory();
        printWinner();
    }

    private void printWinner() {
        Winners winners = gameHistoryDto.getWinners();
        System.out.println(String.format(PRINT_RESULT_FORMAT, "최종 우승자: " + getWinnerView(winners)));
    }

    private String getWinnerView(Winners winners) {
        return winners.getWinnersString();
    }

    private void printHistory() {
        List<CarsDto> history = gameHistoryDto.getHistory();

        for (CarsDto carsDto : history) {
            printCars(carsDto);
        }
    }

    private void printCars(CarsDto carsDto) {
        for (CarDto car : carsDto.getCarDtos()) {
            String positionView = getPositionView(car);
            System.out.println(String.format(PRINT_CAR_FORMAT, car.getName(), positionView));
        }
        System.out.println();
    }

    private String getPositionView(CarDto car) {
        Integer now = car.getPosition();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < now; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}