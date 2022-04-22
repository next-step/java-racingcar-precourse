package racingcar;

import firstClass.Cars;

public class Game {
    private Cars cars;

    public Game( Cars cars ) {
        this.cars = cars;
    }

    public void startCarRacing( int tryCount ) {
        cars.randomMoveCars( tryCount );
        cars.showWinner( tryCount );
    }
}
