package racingcar;

public class CarResult {
    private int location;

    public int getLocation() {
        return location;
    }

    public void move(CarStatus status){
        if(status.isFoward()){
            this.location += 1;
        }

        if(location != 0 && status.isBACKWORD()){
            this.location -= 1;
        }
    }

    public boolean isWinner(int winnerLocation){
        return location == winnerLocation;
    }

}
