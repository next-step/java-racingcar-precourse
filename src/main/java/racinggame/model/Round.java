package racinggame.model;

public class Round {
    int round;

    public Round(String value) {
        try {
            round = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int getRound() {
        return round;
    }
}
