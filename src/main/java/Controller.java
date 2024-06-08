import java.util.ArrayList;
import java.util.List;
import model.Car;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private CarGameStat carGameStat;

    public Controller() {
        carGameStat = new CarGameStat();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void gameStart() {
        enrollCars();
        enrollRepeatNum();
        raceStart();
        raceFinish();
    }

    private void enrollCars() {
        String[] inputCarNames = inputView.inputCars().split(",");
        List<Car> cars = new ArrayList<>();
        for(String carName : inputCarNames) {
            cars.add(new Car(carName));
        }
        carGameStat.setCars(cars);
    }

    private void enrollRepeatNum() {
        int repeatNum = inputView.inputMoveNumber();
        carGameStat.setRepeatNum(repeatNum);
    }

    private void raceStart() {
        outputView.printRaceStartPrompt();
        for(int i = 0; i < carGameStat.getRepeatNum(); ++i) {
            carGameStat.oneSet();
            outputView.PrintSetStatus(carGameStat.getCars());
        }
    }

    private List<Car> getWinners() {
        List<Car> cars = carGameStat.getCars();
        List<Car> winners = new ArrayList<>();

        for(Car car : cars) {
            if(car.getCurPosition() == carGameStat.getFastest())
                winners.add(car);
        }

        return winners;
    }

    private String winnertoString() {
        List<Car> winners = getWinners();
        List<String> winnersName = new ArrayList<>();

        for(Car winner : winners) {
            winnersName.add(winner.getName());
        }

        return String.join(", ", winnersName);
    }

    private void raceFinish() {
        String winners = winnertoString();
        outputView.printWinCars(winners);
    }
}
