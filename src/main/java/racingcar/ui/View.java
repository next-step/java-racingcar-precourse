package racingcar.ui;

import java.util.List;
import racingcar.common.ErrorMessage;
import racingcar.common.ValidUtils;
import racingcar.domain.Name;
import racingcar.domain.TryCount;

public class View {

    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public List<String> insertCarNames() {
        List<String> names = input.insertCarNames();
        while (!validNames(names)) {
            output.printError(ErrorMessage.NAME_VALID_FAIL.toString());
            names = input.insertCarNames();
        }

        return names;
    }

    private boolean validNames(List<String> names) {
        boolean result = true;
        for (String name : names) {
            result = checkNameValid(name, result);
        }
        return result;
    }

    private boolean checkNameValid(String name, boolean now) {
        if (!now) {
            return false;
        }
        return validName(name);
    }

    private boolean validName(String name) {
        if (ValidUtils.stringEmptyValid(name)) {
            return false;
        }

        return !ValidUtils.stringGreaterThenMaxLength(name, Name.MAX_NAME_LENGTH);
    }


    public String insertTryCount() {
        String tryCount = input.insertTryCount();
        while (!validTryCount(tryCount)) {
            output.printError(ErrorMessage.TRY_COUNT_VALID_FAIL.toString());
            tryCount = input.insertTryCount();
        }
        return tryCount;
    }

    private boolean validTryCount(String tryCount) {
        if (ValidUtils.stringIsNotDigit(tryCount)) {
            return false;
        }

        return !ValidUtils.integerLessThenMinNumber(Integer.parseInt(tryCount), TryCount.MINIMUM_TRY_COUNT);
    }

    public void printResultNotice() {
        output.printResultNotice();
    }

    public void printMovingResults(String carsMovingResults) {
        output.printMovingResults(carsMovingResults);
    }

    public void printWinners(List<String> names) {
        output.printWinners(names);
    }

}
