package domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name){
        this.name=name;
        this.distance=0;
    }
    public void forward(){
        this.distance++;
    }
    public int getDistance(){
        return this.distance;
    }


}
