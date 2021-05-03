package racingcar.domain;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void addDistance(Distance distance){
        this.distance += distance.asInt();
    }

    private int asInt(){
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }
}
