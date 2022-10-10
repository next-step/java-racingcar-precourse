package racingcar.domain;

public class Move {

    public boolean moveChk(int randomNum) {
        if(randomNum >= Code.MOVING_FORWARD && randomNum <= Code.END) {
            return true;
        }
        return false;
    }
}
