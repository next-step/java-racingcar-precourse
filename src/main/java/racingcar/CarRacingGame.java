package racingcar;

public class CarRacingGame {

    public void play() {
        CarCollection carCollection = RetryableInputReader.read(InputType.CAR_NAME, CarCollection::new);
    }

}