package racinggame.domain;

public class Distance {
    private int distance;

    public Distance() { }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void addDistance() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
