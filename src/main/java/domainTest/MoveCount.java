package domainTest;

public class MoveCount {

    private int moveCount = 1;

    public int getMoveCount() {
        return moveCount;
    }

    public void judgeMove(int randomNumber) {
        if(randomNumber >= 4){
            ++moveCount;
        }
    }
}
