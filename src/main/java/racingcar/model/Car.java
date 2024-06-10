package racingcar.model;

public class Car {
    private String name;
    private int position;
    private static final int FORWARD_CONDITION = 4;

    public Car (String name){
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move(int condition){
        if(condition>=FORWARD_CONDITION){
            this.position += 1;
        }
    }
}
