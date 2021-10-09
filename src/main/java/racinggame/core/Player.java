package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private Integer score;

    public Player(final String name,
                  final Integer score) {
        this.name = name;
        this.score = score;
    }

    public static List<Player> of(final String[] playerArray) {
        List<Player> players = new ArrayList<>();
        for (String name : playerArray) {
            players.add(new Player(name, 0));
        }
        return players;
    }

    public String getName() {
        return this.name;
    }

    public Integer getScore() {
        return this.score;
    }

    public void addScore(final Integer movement) {
        this.score += movement;
    }

    public void printResult() {
        System.out.println(this.name + " : " + this.getScoreString());
    }

    public String getScoreString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.score; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
