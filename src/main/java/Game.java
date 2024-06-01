import java.util.ArrayList;
import java.util.List;

public class Game {
    private Input input = new Input();
    private Output output = new Output();
    private Rule rule = new Rule();
    private List<Car> racingCars = new ArrayList<>();
    private int gameCnt;

    public void start() {
        carNameProcess();
        cntProcess();
        raceForCnt(gameCnt);
        output.winnerOutput(winnerFind());
    }

    private void carNameProcess() {
        output.carNameOutput();
        while (true) {
            try {
                String carNameInput = input.carNameInput();
                rule.carNameIsNull(carNameInput);
                rule.carNameIsOverSize(carNameInput);
                createCars(carNameInput);
                break;
            } catch (IllegalArgumentException e) {
                output.errorOutput(e.getMessage());
            }
        }
    }

    private void cntProcess() {
        output.tryCntOutput();
        while (true) {
            try {
                String tryCntInput = input.tryCntInput();
                rule.tryCntInputValid(tryCntInput);
                gameCnt = createCnt(tryCntInput);
                break;
            } catch (IllegalArgumentException e) {
                output.errorOutput(e.getMessage());
            }
        }
    }

    private void createCars(String carNameInput) {
        for (String carName : carNameInput.split(",")) {
            racingCars.add(new Car(carName));
        }
    }

    private int createCnt(String tryCntInput) {
        return Integer.parseInt(tryCntInput);
    }

    private void raceForCnt(int cnt) {
        for (int i = 0; i < cnt; i++) {
            for (Car car : racingCars) {
                rule.randomAdvanceOrStop(car);
            }
            output.resultOutput(racingCars);
        }
    }

    private List<Car> winnerFind() {
        List<Car> winner = new ArrayList<>();
        int winnerDistance = 0;
        for (Car car : racingCars) {
            if (car.getDistance() > winnerDistance) {
                winnerDistance = car.getDistance();
            }
        }
        for (Car car : racingCars) {
            if (car.getDistance() == winnerDistance) {
                winner.add(car);
            }
        }
        return winner;
    }
}
