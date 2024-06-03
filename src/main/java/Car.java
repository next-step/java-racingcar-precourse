public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPositionAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(Math.max(0, this.position)));
        return sb.toString();
    }
}
