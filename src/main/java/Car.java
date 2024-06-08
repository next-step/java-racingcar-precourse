public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance += 1;
    }

    public void showDistance() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", distance=" + distance +
            '}';
    }
}

