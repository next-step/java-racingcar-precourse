package racingcar;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Cars {
    private final List<Car> carList = new ArrayList<>();
    private final Queue<Car> queue = new LinkedBlockingQueue<>();

    public Cars(Car... cars) {
        carList.addAll(Arrays.asList(cars));
    }


    public boolean isNumberOfParticipants(final int number) {
        return Objects.equals(carList.size(), number);
    }

    public void play(EnergyGenerator energyGenerator) {
        validationParam(energyGenerator);
        for (Car car : carList) {
            car.move(energyGenerator.create());
        }
    }

    private void validationParam(Object obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("[ERROR] energyGenerator is null");
        }
    }

    public Name[] winner() {
        validationSize();
        carList.forEach(this::findWinner);
        return getWinnerNames();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car : carList) {
            builder.append(String.format("%s",car));
        }
        return builder.toString();
    }

    private Name[] getWinnerNames() {
        Set<Name> res = new HashSet<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().getName());
        }
        return res.toArray(new Name[0]);
    }

    private void validationSize() {
        if (carList.size() < 1) {
            throw new IllegalStateException("[ERROR] no car infos");
        }
    }

    private void findWinner(final Car target) {
        Car source = queue.peek();
        if (Objects.isNull(source)) {
            queue.add(target);
            return;
        }
        compare(source, target);
    }

    private void compare(Car source, Car target) {
        RacingResult result = source.isMatchResult(target);
        if (RacingResult.isWin(result)) {
            return ;
        }
        if (RacingResult.isLose(result)) {
            queue.clear();
        }
        queue.add(target);
    }
}
