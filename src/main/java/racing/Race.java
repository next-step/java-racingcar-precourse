package racing;

import java.util.*;

public class Race {
    private CarSet carset;
    private Round round;
    private EnergyGenerator generator;
    private List<Car> winners;

    public Race(CarSet carset, Round round) {
        this(carset, round, new EnergyGenerator());
    }

    public Race(CarSet carset, Round round, EnergyGenerator generator) {
        this.carset = carset;
        this.round = round;
        this.generator = generator;
        this.winners = Collections.emptyList();
    }


    public void start() {
        for (Integer ignored : round) {
            runStepCars();
        }

        resetWinners();
    }

    private void resetWinners() {
        Mileage maxMileage = carset.reduce((mile, car) -> Mileage.max(mile, car.getMileage()), new Mileage(0));

        this.winners = carset.reduce((acc, car) -> {
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
    }

    public List<Car> getWinners() {
        return winners;
    }

    @Override
    public String toString() {
        return "Race{carset=" + carset + ", round=" + round + '}';
    }
}
