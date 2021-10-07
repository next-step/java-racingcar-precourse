package racinggame;

public class Position {

    private int position = 0;
    private final int MIN_MOVE_NUMBER = 4;

    public static Position of() {
        return new Position();
    }

    public void move(int movePostion) {
        if(movePostion >= MIN_MOVE_NUMBER){
            position++;
        }
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }
}
