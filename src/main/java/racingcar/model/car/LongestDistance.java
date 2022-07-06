package racingcar.model.car;

public class LongestDistance extends Distance {
    public void setDistance(int distance) {
        if (this.distance < distance) {
            this.distance = distance;
        }
    }
}
