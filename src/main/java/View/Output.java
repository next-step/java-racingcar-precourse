package View;

import Model.Car;
import java.util.ArrayList;

public class Output {

    public void printRslt(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println(" ");
    }

    public void printFinalWinner(ArrayList<Car> carList) {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxDist = carList.get(0).getDistance();

        for (Car car : carList) {
            if(maxDist > car.getDistance()) continue;
            if(maxDist < car.getDistance()) {
                winnerList.clear();
                maxDist = car.getDistance();
            }
            winnerList.add(car.getName());
        }

        System.out.print("최종 우승자 : ");

        for(int i=0; i<winnerList.size(); i++) {
            System.out.println(winnerList.get(i));
            if(i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
