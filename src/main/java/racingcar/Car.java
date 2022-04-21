package racingcar;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int FORWARD = 4;
    private static final int MAX_POWER = 9;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private int position;
    private String name;

    Car(String name){
        if(name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하 입니다.");
        }
        this.position = INIT_POSITION;
        this.name = name;
    }

    public int move(int power) {
        if(this.isForward(power)) return ++position;
        return position;
    }

    private boolean isForward(int power) {
        return FORWARD <= power && MAX_POWER >= power;
    }

    public String getPrintString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public int getPosition() { return this.position; }
    public String getName() { return this.name; }
}
