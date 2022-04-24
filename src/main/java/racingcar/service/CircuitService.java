package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Configuration;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ViewMessage;
import racingcar.domain.Circuit;

public class CircuitService {
    public Circuit makeCarRaceCircuit() {
        String roundStr = getRoundCount();
        while(!isValidCircuitRoundCount(roundStr)) {
            roundStr = getRoundCount();
        }
        return new Circuit(Integer.parseInt(roundStr));
    }

    private String getRoundCount() {
        System.out.println(ViewMessage.RACE_COUNT);
        return Console.readLine();
    }

    private boolean isValidCircuitRoundCount(String roundStr) {
        int round = Integer.parseInt(roundStr);
        try {
            validateCircuitRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void validateCircuitRound(int round) {
        if (round < Configuration.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_INPUT);
        }
    }

}
