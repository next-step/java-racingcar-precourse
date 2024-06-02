package view;

import model.Car;

import java.util.List;

public class OutputView {

    public void printGameInfo(List<Car> raceCars){
        StringBuilder info = new StringBuilder("실행 결과\n");
        for (Car car : raceCars){
            info.append(car.getName()).append(" : ").append("-".repeat(car.getPosition()));
            info.append("\n");
        }

        System.out.println(info);
    }

    public void printWinner(List<Car> winners){
        StringBuilder info = new StringBuilder("최종 우승자 : ");
        for(Car car : winners){
            info.append(car.getName());
            info.append(", ");
        }

        System.out.println(info.substring(0, info.length() - 2));
    }
}
