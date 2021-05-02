package racing;

import java.util.*;

public class Race {
    private CarSet carset;
    private Round round;
    private EnergyGenerator generator;
    private OnRoundStepListener listener;

    public Race() {
        this.generator = new EnergyGenerator();
    }

    public Race setGenerator(EnergyGenerator generator) {
        this.generator = generator;
        return this;
    }

    public Race setCars(CarSet carset) {
        this.carset = carset;
        return this;
    }

    public Race setRound(Round round) {
        this.round = round;
        return this;
    }

    public void start() {
        for (Integer ignored : round) {
            runStepCars();
        }
        notifyComplete();
    }

    public void setOnRoundStepListener(OnRoundStepListener listener) {
        this.listener = listener;
    }

    public List<Car> getWinners() {
        Mileage maxMileage = carset.reduce((mile, car) -> Mileage.max(mile, car.getMileage()), new Mileage(0));
        return carset.reduce((acc, car) -> {
            if (maxMileage.equals(car.getMileage())) {
                acc.add(car);
            }
            return acc;
        }, new ArrayList<>());
    }

    private void runStepCars() {
        for (Car car : carset) {
            car.injectEnergy(generator.generate());
        }
        notifyStep();
    }

    private void notifyStep() {
        if (listener != null)
            listener.onStep(carset);
    }

    private void notifyComplete() {
        if (listener != null) {
            List<Car> winners = getWinners();
            listener.onComplete(winners);
        }
    }

    @Override
    public String toString() {
        return "Race{carset=" + carset + ", round=" + round + '}';
    }
}
