package katecam.racingcar.domain;


import java.util.Random;

public final class Car {
    private final String name;
    private final int position;
    private static final Random random;
    static {
        random = new Random();
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Car move(){
        return (random.nextInt(10) >= 4) ? new Car(this.name, this.position + 1) : this;
    }

    public int getPosition() {
        return position;
    }
}
