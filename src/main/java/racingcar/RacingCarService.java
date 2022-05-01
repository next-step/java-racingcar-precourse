package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.GuideMessage;
import racingcar.domain.PlayResult;

public class RacingCarService {

    public void play() {
        GuideMessage.자동차이름_입력안내.printlnMessage();
        Cars cars = new Cars(Console.readLine());
        GuideMessage.진행_횟수_입력안내.printlnMessage();
        PlayResult playResult = cars.startRacing(Console.readLine());
        playResult.printWinnerNames();
    }

}
