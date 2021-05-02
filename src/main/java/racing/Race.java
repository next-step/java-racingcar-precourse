package racing;

import java.util.*;

public class Race {
    private CarSet carset;
    private Round round;
    private EnergyGenerator generator;
    private OnRoundStepListener listener;

    public Race() {
        this(null, null);
    }

    public Race(CarSet carset, Round round) {
        this(carset, round, new EnergyGenerator());
    }

    public Race(CarSet carset, Round round, EnergyGenerator generator) {
        this.carset = carset;
        this.round = round;
        this.generator = generator;
    }

    public void setCars(CarSet carset) {
        this.carset = carset;
    }

    public void setRound(Round round) {
        this.round = round;
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

    public void setGenerator(EnergyGenerator generator) {
        this.generator = generator;
    }
}
