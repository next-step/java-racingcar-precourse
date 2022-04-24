package racingcar;

import java.util.List;

public class Racing {

    private final Cars cars = new Cars();
    private final PlayRecord target_PlayRecord = new PlayRecord();
    private final PlayRecord current_PlayRecord = new PlayRecord();

    private void initCars() {
        System.out.println("Input the name of car ( (,) is the seperator.)");
        cars.makeCar();
    }

    private void initPlayRecord() {
        System.out.println("How many do you try?");
        target_PlayRecord.getInput();
    }

    private void playRecord() {
        System.out.println("result");

        while (!target_PlayRecord.isSame(current_PlayRecord)) {
            cars.move();
            current_PlayRecord.increase();
            cars.showState();
        }

        judgeWinner();
    }

    private void judgeWinner() {
        List<String> winnerNames = cars.getWinners();
        System.out.println( "The final winner : " + String.join(", ", winnerNames));
    }


    public void run() {
        initCars();
        initPlayRecord();
        playRecord();
    }
}
