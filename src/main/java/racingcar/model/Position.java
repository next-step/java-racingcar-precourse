package racingcar.model;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position += position;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Position)){
            return false;
        }
        Position po = (Position) other;
        return po.position == position;
    }
}
