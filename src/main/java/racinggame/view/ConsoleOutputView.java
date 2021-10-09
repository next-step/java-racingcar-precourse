package racinggame.view;

import racinggame.domain.*;


public class ConsoleOutputView {

    private static final String EXECUTION_RESULT_PRINT_FORMAT = "실행 결과";
    private static final String WINNER_NAMES_PRINT_FORMAT = "최종 우승자는 %s 입니다.";
    private static final String WINNER_NAMES_DELIMITER = ",";
    private static final String HYPHEN = "-";

    public ConsoleOutputView() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_PRINT_FORMAT);
    }

    public void print(final RacingGame game) {
        printProgressBars(game);
        printWinners(game);
    }

    private void printProgressBars(final RacingGame game) {
        Cars cars = game.getCars();
        for (Car car : cars.elements()) {

            Name name = car.getName();
            String progressBar = getProgressBar(car);

            System.out.println(name.value() + " : " + progressBar);
        }
        System.out.println();
    }

    private void printWinners(final RacingGame game) {
        if (game.isFinish()) {
            Winners winners = game.winners();
            System.out.printf(WINNER_NAMES_PRINT_FORMAT + "%n", winnerNames(winners));
        }
    }

    private String winnerNames(final Winners winners) {
        return String.join(WINNER_NAMES_DELIMITER, winners.names());
    }

    private String getProgressBar(final Car car) {
        Distance distance = car.getDistance();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.value(); i++) {
            sb.append(HYPHEN);
        }
        return sb.toString();
    }
}