package controller;

import model.Car;
import java.util.*;

public class DecisionMove {
    public static void decide(Vector<Car> carList){ //해당 자동차를 전진할 것인지 멈출것인지 판단하는 기능
        for(int i = 0 ; i < carList.size(); i++) {
            int ramdomValue = getRandom();
            if (ramdomValue >= 4) {
                carList.get(i).setMove(true);
            }
        }
    }

    public static int getRandom(){ //랜덤값을 구하는 기능
        Random random = new Random();
        int randomValue = random.nextInt(10); //0~9
        return randomValue;
    }
}
