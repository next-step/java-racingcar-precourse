package racinggame.car;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> list;

    public CarList() {
        this.list = new ArrayList<Car>();
    }

    public void add(Car car) {
        list.add(car);
    }

    public void process() {
        list.forEach(car -> car.go(Randoms.pickNumberInRange(0, 9)));
    }

    public String getProcessResult() {
        StringBuilder result = new StringBuilder();
        list.forEach(car -> result.append(car.toString() + "\n"));
        result.append("\n");
        return result.toString();
    }

    public String getWinners() {
        StringBuilder result = new StringBuilder();
        int winnerProcess = getwinnerProcess();
        String winners = findWinners(winnerProcess);
        return result.toString();
    }

    private String findWinners(int winnerProcess) {
        StringBuilder result = new StringBuilder();
        for (Car car : list) {
            result.append(findWinner(winnerProcess, car) + ",");
        }
        result.deleteCharAt(result.lastIndexOf(","));
        return result.toString();
    }

    private String findWinner(int winnerProcess, Car car) {
        if (winnerProcess == car.getCarProgress().get()) {
            return car.getCarName().get();
        }
        return "";
    }

    public int getwinnerProcess() {
        int result = 0;
        for (Car car : list) {
            result = getLargerInt(result, car.getCarProgress().get());
        }
        return result;
    }

    private int getLargerInt(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
