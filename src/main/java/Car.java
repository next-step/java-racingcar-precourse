import java.util.Random;

public class Car {
    private String name;
    private int state;

    public Car(String carName) {
        this.name= carName;
        this.state = 0;
    }

    public void move() {

        Random r = new Random();
        int randNum= r.nextInt(0,9);

        if (randNum >= 4) {
            setState(getState() + 1);
        }
    }

    public void printState() {
        System.out.printf("%s : ",this.getName());
        for (int i=0; i<state; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name= name;
    }
    public int getState() {
        return state;
    }
    public void setState(int newState) {
        this.state = newState;
    }
}
