package racinggame;

public class Car {
    private String name;
    private int position;

    public Car(String name) {this.name = name;
        this.position = 0;
    }

    public ActStatus move(int inputNumber) {
        ActStatus actStatus = ActStatus.findByActNumber(inputNumber);
        if (actStatus.doGo()) {
            position++;
        }
        return actStatus;
    }
}
