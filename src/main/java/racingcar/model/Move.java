package racingcar.model;

public class Move {
    private int count;

    public Move() {
        count = 0;
    }

    public Move(int count) {
        this.count = count;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            count++;
        }
    }

    public int moveCount() {
        return count;
    }

    public boolean matchMoveCount(Move move) {
        return this.count == move.count;
    }

    public String replaceMoveCount() {
        StringBuilder s = new StringBuilder("");

        for (int i = 0; i < moveCount(); i++) {
            s.append("-");
        }
        return s.toString();
    }
}
