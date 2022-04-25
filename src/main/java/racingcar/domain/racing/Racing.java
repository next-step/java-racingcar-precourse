package racingcar.domain.racing;

import racingcar.console.Output;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Racing {
    private Cars cars;
    private Turn turn;
    private Referee referee;

    public Racing(Cars cars, Referee referee, Turn turn) {
        this.cars = cars;
        this.referee = referee;
        this.turn = turn;
    }

    public void start() {
        while (!turn.isOver()) {
            play();
            turn.increaseCurrentTurn();
            printTurnOverResult();
        }
        Output.printMessage(Message.WINNER_MESSAGE.getMessage() + referee.whoWin());
    }

    public void play() {
        referee.turnOver(cars.getCars());
    }

    public void printTurnOverResult() {
        Output.printMessage(Message.TURN_OVER_RESULT_MESSAGE.getMessage());
        for (Car car : cars.getCars()) {
            Output.printMessage(car.getCarName().getName() + " : " +
                    getPositionBar(car.getCarPosition().getPosition()));
        }
    }

    public String getPositionBar(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result = result.concat("-");
        }
        return result;
    }
}
