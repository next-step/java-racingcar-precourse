import java.util.ArrayList;
import java.util.List;

public class Game {
    private Input input = new Input();
    private Output output = new Output();
    private Rule rule = new Rule();
    private List<Car> racingCars = new ArrayList<>();
    private int gameCnt;

    public void start() {
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
}
