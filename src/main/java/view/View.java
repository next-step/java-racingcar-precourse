package view;

import model.Car;
import java.util.*;

public class View {
    private String oneStep = "-";

    public View(){
        System.out.println("실행 결과");
    }

    public void print(Vector<Car> carList){ //사용자에게 게임 과정을 보여주는 기능
        for(int i = 0; i < carList.size(); i++){
            Car car = carList.get(i);
            String s = car.getCarName() + " : ";
            System.out.print(s);
            for(int j = 0 ; j < car.getNumberOfMove(); j++){
                System.out.print(oneStep);
            }
            System.out.println();
        }
        System.out.println();
    };
}
