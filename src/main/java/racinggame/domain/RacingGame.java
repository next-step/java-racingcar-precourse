package racinggame.domain;

import racinggame.view.InputView;

public class RacingGame {
    private Cars cars;
    private Laps laps;

    public RacingGame() {
        this.cars = new Cars();
    }

    public void gameSetting() {
        CarNames carNames = InputView.inputCarNames();
        cars.enterRacingGame(carNames.entryNameList());
        laps = InputView.inputLaps();
    }

    public void startRacing() {
        System.out.println("실행 결과");
        while (!laps.isGoal()) {
            cars.MoveOrStopCars();
            cars.currentLocationCars();
            System.out.println();
            laps.passStartLine();
        }
    }

    public void awardRacing() {
        Location firstRecord = cars.inFormFirstRecord();
        Names winners = cars.inFormWinners(firstRecord);
        System.out.printf("최종 우승자는 %s 입니다.%n", winners.printNames());
    }
}
