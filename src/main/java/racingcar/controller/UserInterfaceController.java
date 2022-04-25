package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class UserInterfaceController {
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "ILLEGAL_ARGUMENT";
    public static final String ILLEGAL_STATE_EXCEPTION = "ILLEGAL_STATE";
    public static final Integer ABNORMAL_ROUND_NUMBER_STATE = -1;

    public UserInterfaceController() {
    }

    public String requireCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public Integer requireRacingRoundNumberInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
        Integer roundNumber = ABNORMAL_ROUND_NUMBER_STATE;
        while (Objects.equals(roundNumber, ABNORMAL_ROUND_NUMBER_STATE)) {
            roundNumber = validateRacingRoundNumberInput();
        }
        return roundNumber;
    }

    public Integer validateRacingRoundNumberInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            return ABNORMAL_ROUND_NUMBER_STATE;
        }
    }

    public void printAnnounceRoundResult() {
        System.out.println("\n실행 결과");
    }

    public void printOneRoundResult(String result) {
        System.out.print(result);
    }

    public void printRaceWinner(String winner) {
        System.out.print("최종 우승자: " + winner);
    }

    public void printParticipantInputError(String validate) {
        if (ILLEGAL_ARGUMENT_EXCEPTION.equals(validate)) {
            System.out.println("[ERROR] 자동차 이름은 1글자 이상, 5글자 이하여야 합니다.");
        }
        if (ILLEGAL_STATE_EXCEPTION.equals(validate)) {
            System.out.println("[ERROR] 레이스에 참가할 자동차 이름을 하나 이상 입력해야 합니다.");
        }
    }
}
