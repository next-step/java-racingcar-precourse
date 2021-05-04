package me.ascii92der.racingcar;

public class RacingCar {
    private Cars cars;

    public void start() {
        try {
            cars = new Cars(InputUI.inputCarNames());
            race(InputUI.inputRacingCount());
            end();
        } catch (IllegalArgumentException e) {
            System.out.println("이름 길이 범위 오류");
            start();
        }

    }

    public void race(int count) {
        for (int index = 0; index < count; index++) {
            cars.moves();
            OutputUI.printRaceResult(cars);
        }
    }
    public void end(){
        RacingResult racingResult = new RacingResult(cars.getCarGroup());
        OutputUI.printWinner(racingResult.getWinners());
    }
}
