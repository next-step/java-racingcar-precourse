package racingcar;

public class RacingCarFactory {

    private RacingCarFactory() {}

    private static RacingCars racingCars;

    public static RacingCars create(String carsName) {
        racingCars = new RacingCars();
        String[] carNames = carsName.split(",");

        for (String carName : carNames) {
            generateIfNameCountBetweenOneAndFive(carName);
        }

        return racingCars;
    }

    private static void generateIfNameCountBetweenOneAndFive(String carName) {
        if (Validation.checkNameLength(carName)) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.addRacingCar(racingCar);
        }
    }
}
