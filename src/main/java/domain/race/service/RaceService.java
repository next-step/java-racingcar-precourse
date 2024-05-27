package domain.race.service;

import domain.race.model.Car;
import domain.race.model.Race;
import domain.race.util.RaceUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {

    private static final String DELIMITER = ",";
    private static final String WINNER = "최종우승자 : ";

    public void startRace(String carNames, int round) {
        String[] cars = carNames.split(DELIMITER);
        List<Car> carList = Arrays.stream(cars).map(Car::new).toList();

        Race race = new Race(carList, round);

        while (!race.isFinished()) {
            race.game();
            printCurrentRace(race);
        }

        printPrize(race);
    }

    public void printCurrentRace(Race race) {
        List<Car> carList = race.getCarList();
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + RaceUtils.convertPosition(car.getPosition()));
        }
        System.out.println();
    }

    public void printPrize(Race race) {
        List<String> winnerList = getWinner(race.getCarList());

        String winner = String.join(DELIMITER, winnerList);

        System.out.println(WINNER + winner);
    }

    public List<String> getWinner(List<Car> carList) {
        carList.sort((a, b) -> b.getPosition() - a.getPosition());

        List<String> winnerList = new ArrayList<>();
        winnerList.add(carList.get(0).getName());

        for (int i = 1; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == carList.get(0).getPosition()) {
                winnerList.add(carList.get(i).getName());
                continue;
            }
            break;
        }

        return winnerList;
    }
}
