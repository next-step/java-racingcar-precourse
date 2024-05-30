package Model;

public class Car {

    private String name;
    private String nowStatus;
    private int moveCount;

    public Car(String name, String nowStatus, int moveCount) {
        this.name = name;
        this.nowStatus = nowStatus;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public String getNowStatus() {
        return nowStatus;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
