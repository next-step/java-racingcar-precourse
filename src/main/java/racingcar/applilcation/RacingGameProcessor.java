package racingcar.applilcation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.MessagePrinter;
import racingcar.service.RacingGameOrganizer;

public class RacingGameProcessor {

    private final RacingGameOrganizer racingGameOrganizer;

    public RacingGameProcessor(RacingGameOrganizer racingGameOrganizer) {
        this.racingGameOrganizer = racingGameOrganizer;
    }

    public void prepareGame() {
        MessagePrinter.printRequestCarNamesInput();
        prepareCars();

        MessagePrinter.printRequestTryCountInput();
        prepareTryCount();
    }

    public void playGame() {
        MessagePrinter.printMoveResultMessage();
        racingGameOrganizer.getCars().moveCars(racingGameOrganizer.getTryCount());

        MessagePrinter.printWinnersMessage(racingGameOrganizer.getCars().getWinners());
    }

    private void prepareCars() {
        try {
            racingGameOrganizer.setCars(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            prepareCars();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private void prepareTryCount() {
        try {
            racingGameOrganizer.setTryCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            prepareTryCount();
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
