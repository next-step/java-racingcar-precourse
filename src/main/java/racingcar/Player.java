package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

public class Player {

    String carName;

    int raceCount;

    protected String[] getCarNames() {
        return this.carName.split(Config.PREFIX);
    }

    protected int getRaceCount() {
        return this.raceCount;
    }

    protected void setRaceCount() {
        System.out.println(Message.INPUT_GAME_COUNT.getMessage());
        try {
            this.raceCount = StringToInt(readLine());
            negativeValidation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setRaceCount();
        }
    }

    protected void setCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES.getMessage());
        try {
            this.carName = readLine();
            nullValidation();
            overlapValidation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCarNames();
        }
    }

    private int StringToInt(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NumberFormatException(ExceptionMessage.GAME_COUNT_EMPTY.getMessage());
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.GAME_COUNT_NOT_NUMBER.getMessage());
        }
    }

    private void overlapValidation() {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(getCarNames()));

        if (carNameSet.size() != getCarNames().length) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OVERLAY.getMessage());
        }
    }

    private void negativeValidation() {
        if (this.raceCount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_COUNT_NEGATIVE.getMessage());
        }
    }

    private void nullValidation() {
        if (StringUtils.isBlank(this.carName)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

}