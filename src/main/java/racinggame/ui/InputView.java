package racinggame.ui;

import java.util.Objects;
import nextstep.utils.Console;
import racinggame.domain.Names;
import racinggame.domain.NumberOfMoves;

public class InputView {

    private static final int MAX_ATTEMPTS = 5;
    private static final String RETRY_FAILURE_MESSAGE = "[ERROR] " + MAX_ATTEMPTS + "회 초과. 게임 종료.";

    private InputView() {
    }

    public static Names getRacingCarNamesWithRetry() {
        Names names = null;
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                names = new Names(getRacingCarNames());
                i = MAX_ATTEMPTS;
            } catch (IllegalArgumentException ex) {
                OutputView.printErrorMessage(ex.getMessage());
            }
        }
        validateNames(names);
        return names;
    }

    private static String getRacingCarNames() {
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static void validateNames(Names racingCarNames) {
        if (Objects.isNull(racingCarNames)) {
            throw new IllegalArgumentException(RETRY_FAILURE_MESSAGE);
        }
    }

    public static NumberOfMoves getNumberOfMovesWithRetry() {
        NumberOfMoves numberOfMoves = null;
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                numberOfMoves = new NumberOfMoves(getNumberOfMoves());
                i = MAX_ATTEMPTS;
            } catch (IllegalArgumentException ex) {
                OutputView.printErrorMessage(ex.getMessage());
            }
        }
        validateNumberOfMoves(numberOfMoves);
        return numberOfMoves;
    }

    private static String getNumberOfMoves() {
        OutputView.print("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private static void validateNumberOfMoves(NumberOfMoves numberOfMoves) {
        if (Objects.isNull(numberOfMoves)) {
            throw new IllegalArgumentException(RETRY_FAILURE_MESSAGE);
        }
    }
}
