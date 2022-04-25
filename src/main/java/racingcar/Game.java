package racingcar;

public class Game {
    private static final int MIN_ROUND = 1;
    private int round;

    Game(int round){
        if(round < MIN_ROUND){
            throw new IllegalArgumentException("[ERROR] 게임 라운드는 1 이상으로 입력해주세요");
        }
        this.round = round;
    }

    public int getRound() {
        return this.round;
    }
}
