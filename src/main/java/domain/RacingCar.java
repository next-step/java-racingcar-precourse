package domain;

public class RacingCar {
    private final String name;
    private int moveDistance;

    public RacingCar(String name){
        this.name = name;
        this.moveDistance = 0;
    }

    public RacingCar(String name, int moveDistance){
        this.name = name;
        this.moveDistance = moveDistance;
    }

    public static RacingCar from(String name){
        return new RacingCar(name);
    }

    public String getName(){
        return this.name;
    }

    public int getMoveDistance(){
        return this.moveDistance;
    }

    public void move(){
        this.moveDistance += 1;
    }
}
