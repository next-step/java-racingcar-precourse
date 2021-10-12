package racinggame.model;

import java.util.ArrayList;

public class Racing {

    public static final int MOVE_FORWARD_MIN_NUM = 4;
    public static final int MOVE_FORWARD_MAX_NUM = 9;

    public static void moveForwardOrStay(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
                carList.get(i).moveForward();
        }
    }

    public static boolean validateMoveFoward(int inputNumber) {
        return inputNumber >= MOVE_FORWARD_MIN_NUM && inputNumber <= MOVE_FORWARD_MAX_NUM;
    }
    /*
     * Randoms.pickNumberInRange(0,9) [0~9]
     * 4이상 전진
     * 3이하 멈춤
     * */



}
