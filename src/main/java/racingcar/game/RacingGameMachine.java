package racingcar.game;

import static java.lang.String.join;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.racing.CumulativeRound;

public class RacingGameMachine {
    public static final String WINNERS_DELIMITER = ", ";
    private RacingGame racingGame;

    private RacingGameMachine() {
    }

    public static RacingGameMachine init() {
        return new RacingGameMachine();
    }

    public void start() {
        this.racingGame = RacingGame.initOf(getInputCarNames(), getInputRoundCount());
        racingGame.gameStart();
        if (racingGame.isFinish()) {
            printRacing();
        }
    }

    private void printRacing() {
        printRounds();
        printWinners();
    }

    private void printRounds() {
        System.out.println("실행 결과");
        racingGame.cumulativeRoundsEach(this::printCumulativeRounds);
    }

    private void printCumulativeRounds(final CumulativeRound cumulativeRound) {
        cumulativeRound.getRound()
                .getCars()
                .each(car -> printCumulativeRound(car, cumulativeRound));
        System.out.println();
    }

    private void printCumulativeRound(final Car car, final CumulativeRound cumulativeRound) {
        System.out.print(car.getCarName().getName() + " : ");
        printGoTimes(cumulativeRound.summaryGoCountByCar(car));
        System.out.println();
    }

    private void printGoTimes(final int times) {
        for (int i = 0; i < times; i++) {
            System.out.print("-");
        }
    }


    private void printWinners() {
        System.out.print("최종 우승자: ");
        System.out.println(join(WINNERS_DELIMITER, racingGame.winnersToCars()
                .mapToList(car -> car.getCarName().getName())));
    }

    private void printInputCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    private void printInputRoundNumber() {
        System.out.println("시도 할 회수");
    }

    private InputCarNames getInputCarNames() {
        try {
            printInputCarNames();
            final String carNames = Console.readLine();
            return InputCarNames.valueOf(carNames);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return getInputCarNames();
        }
    }

    private InputRoundCount getInputRoundCount() {
        try {
            printInputRoundNumber();
            final String roundCountString = Console.readLine();
            return InputRoundCount.valueOf(roundCountString);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return getInputRoundCount();
        }
    }

    private void printExceptionMessage(final Exception exception) {
        System.out.println(exception.getMessage());
    }

}
