import java.util.ArrayList;
import java.util.List;

public class Game {
    // 입력 처리 담당
    private InputProcessor inputProcessor = new InputProcessor();

    // 자동차 경주 담당
    private RaceProcessor raceProcessor = new RaceProcessor();

    // 출력 처리 담당
    private OutputProcessor outputProcessor = new OutputProcessor();
    private List<Car> racingCars = new ArrayList<>();
    private int gameCnt;

    public void start() {
        createCars(inputProcessor.processCarNames());
        setGameCnt(inputProcessor.processGameCount());
        raceProcessor.raceForCnt(racingCars, gameCnt);
        outputProcessor.processWinnerName(findWinners());
    }

    private void createCars(String carNameInput) {
        for (String carName : carNameInput.split(",")) {
            racingCars.add(new Car(carName));
        }
    }

    private void setGameCnt(int cnt) {
        gameCnt = cnt;
    }

    private List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        for (Car car : racingCars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
