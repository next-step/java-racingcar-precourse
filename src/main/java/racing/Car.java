package racing;

public class Car {
    
    private String name;
    private int position = 0;
    
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public int getCurrentPosition() {
        return position; 
    }
    
    public void move(Racing racing) {
        position++;
    }
}
