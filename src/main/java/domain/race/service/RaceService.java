package domain.race.service;

import domain.race.model.Car;
import domain.race.model.Race;
import domain.race.util.RaceUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceService {

    private static final String DELIMITER = ",";
    private static final String WINNER = "최종우승자 : ";

    // 입력값이 정상인 경우 새로운 경주 객체를 만들어 경주를 시작하는 함수
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

    // 현재 각 자동차 마다 몇번 전진했는지 표현하는 함수
    public void printCurrentRace(Race race) {
        List<Car> carList = race.getCarList();
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + RaceUtils.convertPosition(car.getPosition()));
        }
        System.out.println();
    }

    // 최종 우승자가 누구인지 찾는 함수
    public void printPrize(Race race) {
        List<String> winnerList = race.getWinner();

        String winner = String.join(DELIMITER, winnerList);

        System.out.println(WINNER + winner);
    }
}
