package racingcar;

import java.util.*;

public class RaceGame {

    private List<Car> cars = new ArrayList();
    private int moveCount;
    private Race race;

    public RaceGame(String input) {
        String[] names = input.split(",");
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public Race run() {
        Map<Integer, Round> map = new HashMap<>();

        for (int i = 1; i <= moveCount; i++) {
            Round round = roundStart();
            map.put(i, round);
        }

        this.race = new Race(map);
        return this.race;
    }

    private Round roundStart() {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int distance = car.move();
            map.put(car.getName(), distance);
        }

        return new Round(map);
    }

    public List getWinners() {
        Round round = race.getLastRound();
        Set<String> racerNames = round.getRacerNames();
        List winners = new ArrayList();
        int winnerDistance = 0;
        for (String racer : racerNames) {
            int distance = round.getDistance(racer);
            winnerDistance = compareDistanceAndSetWinners(winners, winnerDistance, racer, distance);
        }
        return winners;
    }

    private int compareDistanceAndSetWinners(List winners, int winnerDistance, String racer, int distance) {
        if (winnerDistance < distance) {
            winnerDistance = distance;
            winners.clear();
            winners.add(racer);
        } else if (winnerDistance == distance) {
            winners.add(racer);
        }
        return winnerDistance;
    }
}
