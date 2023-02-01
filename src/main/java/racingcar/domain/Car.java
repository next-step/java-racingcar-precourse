package racingcar.domain;


import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
@Getter
public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(GameMovingStrategy movingStrategy){
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    protected int getRandomNum(){
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public boolean comparePosition(Position position) {
        return this.position.compare(position);
    }

    public boolean isWinner(Position position) {
        return this.position.isSame(position);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (this.position.compare(maxPosition)) {
            return this.position;
        }

        return maxPosition;
    }

    public void printPostion() {
        System.out.println(name.getName() + " : " +position.printPosition());
    }
}
