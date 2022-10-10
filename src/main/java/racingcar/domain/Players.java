package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
    private final static String PLAYER_SEPARATOR = ",";

    private final List<Car> players;

    public Players(final String players) {
        String[] split = players.split(PLAYER_SEPARATOR);
        ArrayList<Car> playerList = new ArrayList<>();
        for (String carName : split) {
            playerList.add(new Car(carName));
        }
        this.players = playerList;
    }

    public Players(List<Car> players) {
        this.players = players;
    }

    public List<Car> getPlayers() {
        return players;
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car player : players) {
            player.move(movingStrategy);
        }
    }

    public List<Car> getWinners() {
        Car winner = findWinner();
        return findTieWithWinner(winner);
    }

    private Car findWinner() {
        Car winner = null;
        for (int i = 0; i < players.size() - 1; i++) {
            Car car = players.get(i);
            winner = car.whoIsWinner(players.get(i + 1));
        }
        return winner;
    }

    private List<Car> findTieWithWinner(Car winner) {
        List<Car> winners = new ArrayList<>();
        for (Car player : players) {
            getIfTie(winner, winners, player);
        }
        return winners;
    }

    private void getIfTie(Car winner, List<Car> winners, Car player) {
        if (player.isTie(winner)) {
            winners.add(player);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
