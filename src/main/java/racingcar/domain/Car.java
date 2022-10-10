package racingcar.domain;

public class Car {
    public static final int POSITION_MOVE_STANDARD_NO = 4;
    private final CarName name;
    private Position position;


    public Car(String name, String position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position("0");
    }


    public boolean validMove(int randomNo) {
        return randomNo >= POSITION_MOVE_STANDARD_NO;
    }

    public int move(int randomNo) {
        if (validMove(randomNo)) {
            this.position.addPosition();
        }
        return this.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }


}
