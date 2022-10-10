package racingcar;

public class Car {
    private String name;
    private String moveView;
    private int moveCnt;

    public Car(String carName){
    }
    public String getMoveView() {
        return moveView;
    }

    public void setMoveView(String moveView) {
        this.moveView = moveView;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void setMoveCnt(int moveCnt) {
        this.moveCnt = moveCnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
