package racingcar.view;

import racingcar.dto.RaceResultOutput;
import racingcar.dto.WinnerOutput;

import java.util.function.Consumer;

public class OutputView {

    private final Consumer<String> outputConsumer;

    public OutputView(final Consumer<String> outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    public void printInputCarNamesMessage() {
        outputConsumer.accept("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분) ");
    }

    public void printInputMoveCountMessage() {
        outputConsumer.accept("시도할 회수는 몇 회인가요? ");
    }

    public void print(final RaceResultOutput raceResultOutput) {
        outputConsumer.accept(raceResultOutput.getRaceResult());
    }

    public void print(final WinnerOutput winnerOutput) {
        outputConsumer.accept(String.format("최종 우승자: %s", winnerOutput.getWinners()));
    }

    public void printError(final String message) {
        outputConsumer.accept(String.format("[ERROR] %s", message));
    }
}
