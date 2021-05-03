package racingcar;

public class Car {

    private String name;
    private int position = 0;

    public Car() {}

    public Car(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void forward(boolean isForwardCondition) {
        if(isForwardCondition){
            position++;
        }
    }
}
