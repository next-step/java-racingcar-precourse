package racinggame.domain;

import java.util.Collections;
import java.util.Comparator;

/**
 * Name : Winner <br/>
 * Description : 우승자 클래스
 */
public class Winner {
    public static final String NAME_SEPARATOR = ",";
    private Cars users;

    public Winner(Cars users) {
        this.users = users;
    }

    public String getWinner() {
        StringBuilder winnerName = new StringBuilder();
        int maxPosition = Collections.max(users.getUsers(), Comparator.comparingInt(Car::getPosition)).getPosition();
        for (Car user : users.getUsers()) {
            mapWinnerName(winnerName, maxPosition, user);
        }

        return replaceLastSeparator(winnerName);
    }

    private String replaceLastSeparator(StringBuilder result) {
        return result.substring(0, result.lastIndexOf(NAME_SEPARATOR));
    }

    private void mapWinnerName(StringBuilder winnerName, int maxPosition, Car user) {
        if (maxPosition == user.getPosition()) {
            winnerName.append(user.getName()).append(",");
        }
    }
}
