package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position;

    //초기화
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        int random = generateValue();
        if (random >= 4){
            position++;
        }
    }
    private int generateValue() {
        Random rd = new Random();
        return rd.nextInt(9);
    }
}
