package domain;

public class MoveCount {

    private int moveCount = 0;

    public int getMoveCount() {
        return moveCount;
    }

    public void judgeMove(int randomNumber) {
        if(randomNumber >= 4){
            ++moveCount;
        }
    }
}
