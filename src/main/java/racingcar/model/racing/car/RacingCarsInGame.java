package racingcar.model.racing.car;

import racingcar.model.input.parser.ParseResult;
import racingcar.model.random.number.generator.GeneratedRandomNumber;
import racingcar.model.random.number.generator.RandomNumberGenerator;

import java.util.ArrayList;

public class RacingCarsInGame {
    private final ArrayList<RacingCar> racingCars;

    public RacingCarsInGame(ParseResult<ArrayList<String>> carNamesParseResult) {
        racingCars = new ArrayList<>();
        ArrayList<String> carNamesList = carNamesParseResult.getParseResultValue().getValue();
        for (String s : carNamesList) {
            racingCars.add(new RacingCar(new CarName(s), new Advance()));
        }
    }

    public void playOneRound() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (RacingCar racingCar : racingCars) {
            GeneratedRandomNumber generatedRandomNumber = randomNumberGenerator.generate();
            racingCar.playOneRound(generatedRandomNumber);
        }
    }

    public ArrayList<RacingCar> getRacingCars() {
        return racingCars;
    }
}
