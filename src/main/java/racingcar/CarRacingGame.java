package racingcar;

public class CarRacingGame {

    public void play() {
        CarCollection carCollection = RetryableInputReader.read(InputType.CAR_NAME, CarCollection::new);
        int moveCount = RetryableInputReader.read(InputType.MOVE_COUNT, Integer::parseInt);
    }

}