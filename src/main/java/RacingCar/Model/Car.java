package Model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getPosUnits(int carPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
