package racingcar;

import java.util.Optional;

public class RacingService {
    private final Energy energyGauge = RacingConfig.getDefaultEnergyGauge();
    private final EnergyGenerator generator;
    private RacingCount racingCount;
    private Cars cars;

    public RacingService() {
        this.generator = new EnergyGenerator(RacingConfig.getMinRandom(),RacingConfig.getMaxRandom());
    }

    public void userInput() {
        Presenter.disPlayPrintForName();
        this.cars = createCars(waitValidCarNames());
        Presenter.disPlayPrintForTryCount();
        this.racingCount = waitValidTryCount();
    }

    public void play() {
        Presenter.displayResultTitle();
        racing();
    }

    public void printWinner() {
        Presenter.winnerPrint(cars.winner());
    }

    private void racing() {
        while (!isFinish()) {
            perMatch();
        }
    }

    private boolean isFinish() {
        try {
            this.racingCount = this.racingCount.decrease();
            return false;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void perMatch() {
        cars.play(this.generator);
        Presenter.disPlayCar(cars);
    }

    private Cars createCars(final Name ... names) {
        Car[] cars = new Car[names.length];
        for (int i=0; i < names.length; i++) {
            cars[i] = new Car(names[i],energyGauge);
        }
        return new Cars(cars);
    }

    private Name[] waitValidCarNames() {
        while (true){
            Optional<Name[]> isValidNames = Presenter.inputCarNames();
            if (isValidNames.isPresent()) {
               return isValidNames.get();
            }
        }
    }

    private RacingCount waitValidTryCount() {
        while (true){
            Optional<RacingCount> isValidRacingCount = Presenter.inputRacingCount();
            if (isValidRacingCount.isPresent()) {
                return isValidRacingCount.get();
            }
        }
    }
}
