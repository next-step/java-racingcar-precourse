package racingcar.model;

public class Car {
    private  static  final int  maxLength = 5;
    private  static  final int  moveStandard = 4;
    private  static  final String overInputErrMsg = "자동차의 이름이 " + maxLength + "자를 초과하였습니다.\n";
    private  static  final String emptyInputErrMsg = "미입력된 자동차 이름이 있습니다.\n";

    private final String name;
    private int distance;
    public Car(String name) {
        if(isNullOrEmpty(name)) throw new IllegalArgumentException(emptyInputErrMsg);
        if(isOverLength(name)) throw new IllegalArgumentException(overInputErrMsg);
        this.name = name;
        this.distance = 0;
    }
    public String getName() {
        return name;
    }

    private boolean isNullOrEmpty(String name){
        return name == null || name.trim().isEmpty();
    }

    private boolean isOverLength(String name){
        return name.length() > maxLength;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int randomNum) {
        if(isMovable(randomNum)) this.distance++;
    }

    public boolean isMovable(int randomNum) {
        return randomNum >= moveStandard;
    }
}
