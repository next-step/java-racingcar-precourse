package view;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.CarRace;

public class OutputView {

    StringBuilder sb = new StringBuilder();

    public void printAnnounce(){
        System.out.println("실행 결과");
    }

    public void printRace(CarRace carRace){
        for(Car car : carRace.getCarList()){
            sb.setLength(0);
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(car.getPosition()));
            System.out.println(sb);
        }
        System.out.println();
    }

    public void printWinner(CarRace carRace) {
        sb.setLength(0);
        sb.append("최종 우승자 :");
        for(String name : getWinner(carRace)){
            sb.append(" ");
            sb.append(name);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    private List<String> getWinner(CarRace carRace){
        List<String> winnerNames = new ArrayList<>();
        for(Car car : carRace.getCarList()){
            if(car.getPosition() == getMax(carRace)){
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int getMax(CarRace carRace){
        int max = 0;
        for(Car car : carRace.getCarList()){
            if(car.getPosition() > max){
                max = car.getPosition();
            }
        }
        return max;
    }

}
