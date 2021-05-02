package racing;

public class Race {
    private CarSet carset;
    private Round round;
    private EnergyGenerator generator;

    public Race(CarSet carset, Round round) {
        this(carset, round, new EnergyGenerator());
    }

    public Race(CarSet carset, Round round, EnergyGenerator generator) {
        this.carset = carset;
        this.round = round;
        this.generator = generator;
    }


    public void start() {
        for (Integer index : round) {
            runStepCars();
        }
    }

    private void runStepCars() {
        for (Car car : carset) {
            car.injectEnergy(generator.generate());
        }
    }
}
