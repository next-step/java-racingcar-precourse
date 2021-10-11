package racinggame.model;

public class Car {

    public static final int MIN_GO_NUM = 4;
    public static final int MAX_GO_NUM = 9;
    public static final int GO_DISTANCE = 1;

    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(0);
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name.setName(name);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void setPosition(int position) {
        this.position.setPosition(position);
    }

    public static CarStatus judgeMoving(int num) {
        if(num >= MIN_GO_NUM && num <= MAX_GO_NUM) {
            return CarStatus.GO;
        }
        return CarStatus.STOP;
    }


    public int move(CarStatus carStatus) {
        if(carStatus == CarStatus.GO){
            position.setPosition(getPosition()+GO_DISTANCE);
        }
        return position.getPosition();
    }
}
