package vo;

import java.util.List;

public class CarVo {
    private List<String> carName;
    private List<Integer> carScore;

    public void setCarScore(List<Integer> carScore) {
        this.carScore = carScore;
    }

    public void setCarName(List<String> carName) {
        this.carName = carName;
    }

    public List<Integer> getCarScore() {
        return carScore;
    }

    public List<String> getCarName() {
        return carName;
    }
}
