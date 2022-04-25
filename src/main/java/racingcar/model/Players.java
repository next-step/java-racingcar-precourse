package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.model.primitive.Name;
import racingcar.strategy.MovementStrategy;

public class Players {

    private static final int INITIAL_DISTANCE = 0;
    private static final String PLAYER_DELIMITER = ":" ;
    private static final String SCORE_DELIMITER = ";" ;
    private final List<Car> players;

    public Players(String userNames) {
        this.players = new ArrayList<>();

        String[] splits = userNames.split(",");
        for (String username : splits) {
            this.players.add(new Car(username.trim(), INITIAL_DISTANCE));
        }
    }

    public void moveWithStrategy(MovementStrategy movementStrategy) {
        for (Car player : players) {
            player.move(movementStrategy);
        }
    }

    private String firstPlaceDistance() {
        return Collections.max(players,
                        Comparator.comparing((value) -> value.showPrimitiveValueWithParam("Distance")))
                .showPrimitiveValueWithParam("Distance");
    }

    private List<String> firstPlacePlayers() {
        List<String> members = new ArrayList<>();
        String firstPlace = firstPlaceDistance();
        for (Car player : players) {
            findPlayersWithFirstPlaceParameter(members, firstPlace, player);
        }

        return members;
    }

    private void findPlayersWithFirstPlaceParameter(List<String> members, String firstPlace, Car player) {
        if (player.showPrimitiveValueWithParam("Distance").equals(firstPlace)) {
            members.add(player.showResult());
        }
    }

    public List<Name> firstPlayerNames() {
        List<String> playersList = firstPlacePlayers();
        List<Name> playerNames = new ArrayList<>();
        for (String player : playersList) {
            playerNames.add(new Name(player.split(PLAYER_DELIMITER)[0]));
        }

        return playerNames;
    }

    public String currentScores() {
        StringBuilder sb = new StringBuilder();
        for (Car car : players) {
            sb.append(car.showResult()).append(SCORE_DELIMITER);
        }
        return sb.toString();
    }
}
