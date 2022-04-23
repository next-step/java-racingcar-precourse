package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.handler.ViewHandler;

public class RaceCar {
    private CarHub hub;
    private TryCount tryCount;

    public void run() {
        init();
        simulate();
    }

    private void init() {
        hub = initCarHub();
        tryCount = initTryCount();
    }

    private CarHub initCarHub() {
        while(true) {
            try {
                ViewHandler.printNameInput();
                return new CarHub(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private TryCount initTryCount() {
        while (true) {
            try {
                ViewHandler.printTryCountInput();
                return new TryCount(Console.readLine());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void simulate() {
        ViewHandler.printSimulateResultTitle();

        for (int count = 0; count < tryCount.getValue(); count++) {
            hub.goCars();
            ViewHandler.printSimulateResult(hub.getCars());
        }

        final Winners winners = new Winners(hub.getCars());
        ViewHandler.printWinners(winners.getWinners());
    }
}
