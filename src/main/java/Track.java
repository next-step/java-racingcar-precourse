import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Track {
    List<Car> carList;

    public Track() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public void race() {
        for (Car car : carList) {
            car.moveOrDont(generateAccelValue());
        }
    }

    private int generateAccelValue() {
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    public Car getCar(int i) {
        return this.carList.get(i);
    }

    public List<Car> getWinners() {
        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        List<Car> winnerList = getWinnersBySortedList();
        return winnerList;
    }

    private List<Car> getWinnersBySortedList() {
        int index = 0;
        List<Car> winnerList = new ArrayList<>();
        do {
            winnerList.add(carList.get(index));
            index++;
        } while (!isIndexOverflow(index) && isSameWinner(winnerList, index));
        return winnerList;
    }

    private boolean isSameWinner(List<Car> winnerList, int index) {
        return winnerList.get(winnerList.size() - 1).getPosition() == carList.get(index).getPosition();
    }

    private boolean isIndexOverflow(int index) {
        return carList.size() <= index;
    }
}
