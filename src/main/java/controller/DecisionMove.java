package controller;

import model.Car;
import java.util.*;

public class DecisionMove {
    public static void decide(Car car){ //해당 자동차를 전진할 것인지 멈출것인지 판단하는 기능
        int ramdomValue = getRandom();
        if (ramdomValue >= 4 ){
            car.setMove(true);
        }
    }
}
