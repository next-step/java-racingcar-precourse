package model;

public class Car {

    private final String name;
    private int position;
    private final static int ADVANCE_BOUND = 4;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void advance(int number){
        if(number >= ADVANCE_BOUND){
            this.position = this.position + 1;
        }
    }

}
