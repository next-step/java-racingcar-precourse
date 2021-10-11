package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int score = 0;

    public Player(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(final int movement) {
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

    /**
     * 이름에 대한 유효성 검사 결과와, 이름들의 배열을 받아 결과를 반환
     * 유효성 검사 결과가 true일 경우, Player 객체의 컬렉션 반환
     * 유효성 검사 결과 false일 경우, null 반환
     * @param isValidateInput 유효성 검사 결과
     * @param playerArray 경주할 자동차 이름들의 배열
     * @return
     */
    public static List<Player> getPlayersOrNull(final boolean isValidateInput,
                                                final String[] playerArray) {
        if (!isValidateInput) return null;

        List<Player> players = new ArrayList<>();
        for (String name : playerArray) {
            players.add(new Player(name));
        }

        return players;
    }

}
