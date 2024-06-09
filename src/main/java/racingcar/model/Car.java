package racingcar.model;

import java.util.Random;

public class Car {
    private static final int MINIMUM_NUM = 4;
    private String name;
    private int position = 0;

    public Car(String name){
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하로 입력하세요.");
        }
        this.name = name;
    }

    public void move(){
        if(canMove()){
            position++;
        }
    }

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_NUM;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
