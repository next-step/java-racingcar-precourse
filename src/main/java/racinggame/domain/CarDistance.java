package racinggame.domain;

public class CarDistance {
    private int carDistance;
    private static final int MOVE_JUDGE_VALUE = 4;

    public CarDistance() {
        this.carDistance = 0;
    }

    public void change(int randomNumber) {
        if (randomNumber >= MOVE_JUDGE_VALUE) {
            this.carDistance++;
        }
    }

    public String convertToHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carDistance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getCarDistance() {
        return carDistance;
    }
}
