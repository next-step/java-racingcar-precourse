package Model;

public class Car {
    private final String name;
    private int progress;

    public Car(String name){
        this.name = name;
        this.progress = 0;
    }
    public String getName(){
        return name;
    }
    public int getProgress(){
        return progress;
    }

    //progress 증가
    public void move(){
            progress++;
    }
}
