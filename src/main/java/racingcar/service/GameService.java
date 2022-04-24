package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class GameService {

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputCarService inputCarService = new InputCarService(Console.readLine());
        System.out.println("시도할 회수");
        CarMoveService carMoveService = new CarMoveService(Console.readLine());
        carMoveService.move(inputCarService);
        resultGame(inputCarService.getCarNames(), carMoveService.getCarMoveCount());
    }

    private void resultGame(String[] names, int[] counts) {
        ResultGameService resultGameService = new ResultGameService(names, counts);
        resultGameService.resultGame();
        resultGameService.resultGameWin();
    }

}
