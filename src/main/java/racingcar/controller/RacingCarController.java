package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarGroup;
import racingcar.view.RacingCarViewer;

public class RacingCarController {

    public void start() {
        RacingCarViewer.printFirstQuestion();
        CarGroup carGroup = generateCarGroup();

        RacingCarViewer.printSecondQuestion();
        int loopCount = generateLoopCount();

        RacingCarViewer.printResult();
        carGroup.raceByTimes(loopCount);
        RacingCarViewer.printWinners(carGroup.getWinners());
    }

    private CarGroup generateCarGroup() {
        String carNames = Console.readLine();
        try {
            return CarGroup.fromNames(carNames);
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateCarGroup();
        }
    }

    private int generateLoopCount() {
        String rawLoopCount = Console.readLine();
        try {
            return Integer.parseInt(rawLoopCount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            return generateLoopCount();
        }
    }
}
