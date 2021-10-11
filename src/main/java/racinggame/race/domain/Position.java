package racinggame.race.domain;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition() {
        this.position++;
    }
}
