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

    public void printWinner(Vector<String> winner){ //우승자를 출력하는 기능
        System.out.print("최종 우승자 : ");
        for (int i = 0; i<winner.size(); i++){
            if (i == winner.size()-1) { //마지막 우승자를 출력하는 경우 ,없이 출력
                System.out.println(winner.get(i));
                break;
            }
            System.out.print(winner.get(i)+", ");

        }
    }
}
