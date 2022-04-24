package racingcar.view;

import racingcar.domain.CarDto;
import racingcar.domain.CarsDto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final String VISUALIZE_DELIMETER = "-";
    private static final String NAME_POSITION_DELIMETER = " : ";
    private static final String WINNER_RESLUT_END_MESSAGE = "최종 우승자: ";
    private static final String WINNER_RESLUT_START_MESSAGE = "\n실행 결과";
    private static final String LINE_BREAK = "\n";
    private static final int START_POSITION = 0;

    public void printStartMessage() {
        System.out.println(WINNER_RESLUT_START_MESSAGE);
    }

    public void printRoundResult(CarsDto carsDto) {
        StringBuilder roundResult = new StringBuilder();
        for (CarDto carDto : carsDto.getCars()) {
            String roundMessage = String.join(NAME_POSITION_DELIMETER, carDto.getName(), getVisualizedPosition(carDto.getPosition()));
            roundResult.append(roundMessage);
            roundResult.append(LINE_BREAK);
        }

        System.out.println(roundResult);
    }

    public void printWinners(List<CarDto> winners) {
        StringBuilder winnerResult = new StringBuilder(WINNER_RESLUT_END_MESSAGE);

        List<String> winnerNames = new ArrayList<>();
        for (CarDto car : winners) {
            winnerNames.add(car.getName());
        }
        winnerResult.append(String.join(SPLIT_DELIMITER, winnerNames));

        System.out.println(winnerResult);
    }

    private String getVisualizedPosition(int position) {
        StringBuilder visualPosition = new StringBuilder();
        for (int idx = START_POSITION; idx < position; idx++) {
            visualPosition.append(VISUALIZE_DELIMETER);
        }
        return visualPosition.toString();
    }

}
