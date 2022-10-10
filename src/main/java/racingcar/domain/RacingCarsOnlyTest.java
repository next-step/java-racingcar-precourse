package racingcar.domain;

public class RacingCarsOnlyTest extends RacingCars {


    public RacingCarsOnlyTest(String name) {
        super(name);
    }

    public String race(int[] randomNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int randomNumber = randomNumbers[i];
            sb.append(car.move(randomNumber, new CarForwardStrategy())).append("\n");
        }
        return sb.toString();
    }
}
