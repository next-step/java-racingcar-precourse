package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    protected void run() {
        start();
    }

    private void start() {
        Player player = new Player();
        setCars(player);
        player.setRaceCount();
        racing(player.getRaceCount());
        racingResult();
    }

    private void setCars(Player player) {
        try {
            player.setCarNames();
            setCar(player.getCarNames());
            sizeValidation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCars(player);
        }
    }

    private void setCar(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

    private void racing(int raceCount) {
        System.out.println(Message.RESULT.getMessage());
        for (int i = 0; i < raceCount; i++) {
            racingRoundCar();
            racingRoundResult();
        }
    }

    private void racingRoundCar() {
        cars.forEach(car -> car.move(pickNumberInRange(Config.START_NUM, Config.END_NUM)));
    }

    private void racingRoundResult() {
        cars.forEach(car -> System.out.printf("%s : %s\n", car.name, car.getRaceStatus()));
        System.out.println(" ");
    }

    private void racingResult() {
        int max = getMaxMoveCount();

        cars.removeIf(car -> car.getMoveCount() != max);

        getWinner();
    }

    private int getMaxMoveCount() {
        List<Integer> moveCounts = new ArrayList<>();

        cars.forEach(car -> moveCounts.add(car.getMoveCount()));

        return Collections.max(moveCounts);
    }

    private void getWinner() {
        System.out.println(Message.WIN.getMessage());
        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {
            winners.append(car.getName()).append(Config.PREFIX);
        }

        System.out.println(winners.substring(0, winners.length() - 1));
    }

    private void sizeValidation() {
        if (cars.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

}