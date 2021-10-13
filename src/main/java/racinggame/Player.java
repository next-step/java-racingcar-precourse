package racinggame;

import nextstep.utils.Console;

import java.util.*;

public class Player {
    public List<String> setCarNames() {
        List<String> carNames = new ArrayList<>();
        boolean validCarNames = false;
        while (!validCarNames) {
            System.out.println(Message.REQUEST_CAR_NAMES.getMessage());
            String inputCarNames = Console.readLine();
            carNames = Arrays.asList(inputCarNames.replace(" ", "").split(","));
            validCarNames = validCarNames(carNames);
        }
        return carNames;
    }

    private boolean validCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (!Boundary.NAME.isWithinRange(carName.length())) {
                System.out.println(Message.NAME_RANGE.getMessage());
                return false;
            }
        }
        return true;
    }

    public int setNumberOfAttempt() {
        String numberOfAttempt = null;
        boolean validNumberOfAttempt = false;
        while (!validNumberOfAttempt) {
            System.out.println(Message.REQUEST_ATTEMPTS.getMessage());
            numberOfAttempt = Console.readLine();
            validNumberOfAttempt = validNumberOfAttempt(numberOfAttempt);
        }
        return Integer.parseInt(numberOfAttempt);
    }

    private boolean validNumberOfAttempt(String strNumberOfAttempt) {
        int numberOfAttempt;
        try {
            numberOfAttempt = Integer.parseInt(strNumberOfAttempt);
        } catch (Exception e) {
            System.out.println(Message.ATTEMPTS_INPUT_TYPE.getMessage());
            return false;
        }
        return validRangeNumberOfAttempt(numberOfAttempt);
    }

    private boolean validRangeNumberOfAttempt(int numberOfAttempt) {
        if (!Boundary.ATTEMPT.isWithinRange(numberOfAttempt)) {
            System.out.println(Message.ATTEMPTS_RANGE.getMessage());
            return false;
        }
        return true;
    }

    public Map<String, Object> setUserInput() {
        Map<String, Object> userInput = new HashMap<>();
        List<String> carNames = setCarNames();
        int numberOfAttempt = setNumberOfAttempt();
        userInput.put("carNames", carNames);
        userInput.put("numberOfAttempt", numberOfAttempt);
        return userInput;
    }
}
