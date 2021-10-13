package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private List<String> winners;
    private int maxPosition;

    public Winner(List<Car> cars) {
        this.cars = cars;
        this.winners = new ArrayList<>();
        this.maxPosition = 0;
    }

    private static List<Integer> mapPosition(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public int calMaxPosition() {
        maxPosition = Collections.max(mapPosition(cars));
        return maxPosition;
    }

    private void setWinners() {
        if(maxPosition == 0) {
            return;
        }
        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
    }

    public List<String> findWinners() {
        calMaxPosition();
        setWinners();
        return winners;
    }

    public void printWinners() {
        findWinners();
        if (winners.size() == 0) {
            System.out.println(Message.NO_WINNER.getMessage());
            return;
        }
        System.out.println("최종 우승자는 " + String.join(",", winners) + " 입니다.");
    }
}
