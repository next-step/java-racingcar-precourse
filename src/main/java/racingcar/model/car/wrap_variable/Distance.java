package racingcar.model.car.wrap_variable;

public class Distance {
    private int distance;
    StringBuilder strDistance;

    public Distance() {
        this.distance = 0;
        this.strDistance = new StringBuilder();
    }

    public Distance(int distance) {
        this.distance = distance;
        this.strDistance = new StringBuilder();

        for(int i = 0 ; i < distance ; i++) {
            this.strDistance.append("-");
        }
    }

    public void plusDistance() {
        this.distance++;
        strDistance.append("-");
    }

    public int getIntDistance() {
        return this.distance;
    }

    public String getStrDistance() {
        return this.strDistance.toString();
    }
}
