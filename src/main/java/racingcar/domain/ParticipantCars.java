package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.List;

import static racingcar.utils.RacingCarConstants.CAR_NAME_SPLIT_CHARACTER;
import static racingcar.utils.RacingCarConstants.MAX_RANDOM_NUM;
import static racingcar.utils.RacingCarConstants.MIN_RANDOM_NUM;

public class ParticipantCars {
    private final List<Car> cars;

    public ParticipantCars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveParticipantCarsByInputCount(int inputMoveCount) {
        for (int i = 0; i < inputMoveCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(new Accelerator(RandomNumberGenerator.generateNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM)));
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.printf("%s : %s%n", car.getCarName(), car.getDistancePrintMessage());
    }

    public void printWinner() {
        int winnerCount = getWinnerCount();
        StringBuilder sb = new StringBuilder();
        String separator = CAR_NAME_SPLIT_CHARACTER + " ";
        for (int i = 0; i < winnerCount; i++) {
            sb.append(cars.get(i).getCarName());
            sb.append(separator);
        }
        sb.delete(sb.length() - separator.length(), sb.length());
        System.out.println("최종 우승자 : " + sb);
    }

    private int getWinnerCount() {
        sortCarsByDistanceDesc();
        int winnerCount = 0;
        Car WinnerCar = cars.get(0);
        for (Car compareCar : cars) {
            winnerCount = compareCoWin(winnerCount, WinnerCar, compareCar);
        }
        return winnerCount;
    }

    private void sortCarsByDistanceDesc() {
        cars.sort((alphaCar, betaCar) -> {
            int AlphaCarDistance = alphaCar.getDistance();
            int betaCarDistance = betaCar.getDistance();
            return Integer.compare(betaCarDistance, AlphaCarDistance);
        });
    }

    private int compareCoWin(int winnerCount, Car WinnerCar, Car car) {
        if (WinnerCar.getDistance() == car.getDistance()) {
            winnerCount++;
        }
        return winnerCount;
    }
}
