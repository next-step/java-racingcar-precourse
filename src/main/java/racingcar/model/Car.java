package racingcar.model;

public class Car {
    private static final int MINIMUM_NUM = 4;
    private String name;
    private int position = 0;
    private int randomNum = (int)(Math.random() * 10);

    public Car(String name){
        this.name = name;
    }

    private int move(int position){
        if(randomNum >= MINIMUM_NUM){
            position++;
        }
        return position;
    }

    private int getPosition(){
        return position;
    }
}
