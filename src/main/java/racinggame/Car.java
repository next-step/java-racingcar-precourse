package racinggame;

public class Car {
    private String name;
    private int position;

    public Car(String name) {this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public ActStatus move(int inputNumber) {
        ActStatus actStatus = ActStatus.findByActNumber(inputNumber);
        if (actStatus.doGo()) {
            position++;
        }
        return actStatus;
    }

    public String getMoveStatus() {
        StringBuilder moveStatus = new StringBuilder().append(name).append(" : ");
        for (int i=0; i < position; i++) {
            moveStatus.append(ActStatus.GO.getActExpress());
        }
        return moveStatus.toString();
    }
}
