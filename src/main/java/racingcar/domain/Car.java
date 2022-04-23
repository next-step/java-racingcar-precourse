package racingcar.domain;

public class Car {

    public static final int INIT_POS = 0;
    public static final String PATH_PATTERN = "-";

    private CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = INIT_POS;
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position += 1;
        }
    }

    public String getPath() {
        String path = "";
        for (int i=0; i<this.position; i++) {
            path = path.concat(PATH_PATTERN);
        }
        return path;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }
}
