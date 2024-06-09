package controller;

import model.Car;
import java.util.*;

public class DecisionMove {
    public static void decide(Vector<Car> carList){ //해당 자동차를 전진할 것인지 멈출것인지 판단하는 기능
        for(int i = 0 ; i < carList.size(); i++) {
            carList.get(i).tryIncreaseNumberOfMove(); //각 자동차마다 tryIncreaseNumberOfMove 메소드를 호출하여 전진할지 멈출 것인지 정함
        }
    }
}
