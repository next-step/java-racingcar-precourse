public class Car {

    private String name;
    private int distance;

    Car(String n, int d) {
        this.name = n;
        this.distance = d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
