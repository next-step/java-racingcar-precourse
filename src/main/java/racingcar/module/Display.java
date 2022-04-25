package racingcar.module;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.RacingCar;

public class Display {

    private static final String ERROR_LOG_PREFIX = "[ERROR] ";

    public String inputRacingCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로구분)");
        return Console.readLine();
    }

    public String inputRacingCount() {
        System.out.println("시도할 회수");
        return Console.readLine();
    }

    public void printRacingResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            String repeat = repeat('-', car.getMoved());
            System.out.format("%s : %s\n", car.getName(), repeat);
        }
    }

    public void printWinners(List<String> winners) {
        String joining = String.join(", ", winners);
        System.out.format("최종 우승자: %s", joining);
    }

    public void printError(Exception e) {
        System.out.println(ERROR_LOG_PREFIX + e.getMessage());
    }

    private String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }
}
