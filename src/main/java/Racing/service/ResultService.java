package Racing.service;

import Racing.domain.Car;
import Racing.domain.Cars;
import java.util.ArrayList;
import java.util.List;

//게임 결과를 처리하는 서비스

public class ResultService {

    public List<String> result(Cars cars) {
        List<String> winner;
        int maxScore = getMaxScore(cars);
        winner = getWinner(cars, maxScore);

        return winner;
    }

    public int getMaxScore(Cars cars) {
        int maxScore = 0;
        for (Car car : cars.getCars()) {
            if (maxScore < car.getDistanceBar().length()) {
                maxScore = car.getDistanceBar().length();
            }
        }
        return maxScore;
    }

    public List<String> getWinner(Cars cars, int maxScore) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (maxScore == car.getDistanceBar().length()) {
                winner.add(car.getName());
            }
        }

        return winner;
    }


}
