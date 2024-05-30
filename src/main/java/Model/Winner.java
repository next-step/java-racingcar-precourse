package Model;

public class Winner {
    private String winner;
    private boolean firstWinner;

    public Winner() {
        this.winner = "";
        this.firstWinner = true;
    }

    public void addWinner(String winnerCar) {
        if (firstWinner) {//첫번째 우승자이면 그냥 더하기 연산
            firstWinner = false;
            addFirstWinner(winnerCar);
            return;
        }
        //첫번째 이후 우승자라면 ", 우승자" 를 더함
        addNotFirstWinner(winnerCar);
    }
    //단순하게 우승자 더하기
    public void addFirstWinner(String winnerCar) {
        winner += winnerCar;
    }
    //", "을 포함하여 우승자 더하기
    public void addNotFirstWinner(String winnerCar) {
        winner = winner + ", " + winnerCar;
    }
}
