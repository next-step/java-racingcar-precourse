package racinggame.model;

public class Car {

    public static final int MIN_GO_NUM = 4;
    public static final int MAX_GO_NUM = 9;

    public static boolean isMove(int num) {
        return num >= MIN_GO_NUM && num <= MAX_GO_NUM;
    }
}
