package racingcar;

import racingcar.View.LapsInput;
import racingcar.View.NameInput;
import racingcar.View.View;

public class Game {
    public Game(){
        Names names = NameInput.input();
        int laps = LapsInput.input();
        Cars cars = CarsGenerator.create(names);
        move(laps, cars);
        getWinner(cars);
    }

    private void move(int laps, Cars cars) {
        for (int i = 0; i < laps; i++){
            cars.move();
        }
    }

    private void getWinner(Cars cars) {
        Cars winner = Referee.getWinner(cars);
        View.print("최종 우승자: ");
        View.printObj(winner);
    }
}
