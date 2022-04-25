package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

/**
 * 레이싱 경기 운영자
 */
public class Official {

    private final String INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TOTAL_LAPS_GUIDE = "시도할 회수는 몇회인가요?";
    private final String RACE_RESULT_GUIDE = "실행결과";
    private final String WINNER_GUIDE = "최종 우승자: %s";

    public String readCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE);
        return Console.readLine();
    }

    public String readTotalLaps() {
        System.out.println(INPUT_TOTAL_LAPS_GUIDE);
        String totalLaps = Console.readLine();
        System.out.println();
        return totalLaps;
    }

    public void start() {
        System.out.println(RACE_RESULT_GUIDE);
    }

    public void announce(Winners winners) {
        System.out.printf(WINNER_GUIDE, winners.winners());
    }
}
