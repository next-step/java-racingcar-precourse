package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Winners;
import racingcar.domain.dto.RacingCarDTOList;

public class ConsoleRacingCarView implements RacingCarView {
    @Override
    public String getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String getAttemptRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    @Override
    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    @Override
    public void printRace(RacingCarDTOList carDTOList) {
        System.out.println(carDTOList);
    }

    @Override
    public void printResult(Winners winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
