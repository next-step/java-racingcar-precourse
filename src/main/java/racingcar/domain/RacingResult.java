package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private int maxPosition = 0;
    private List<Car> winningCarList = new ArrayList<>();

    public RacingResult(Cars cars){
        for(Car car : cars.getCarList()){
            racingAnalysis(car);
        }
    }

    public List<Car> getWinningCarNameList(){
        return winningCarList;
    }

    public void consoleOutWinningCars(){
        String winningCars = "";
        for(Car car : winningCarList){
            winningCars += car.getCarName().getName() + ", ";
        }
        if(!winningCars.equals("")){
            System.out.println("최종 우승자 : "+winningCars.substring(0,winningCars.length()-2));
        }else if (winningCars.equals("")){
            System.out.println("최종 우승자가 없습니다.");
        }
    }

    public void racingAnalysis(Car car){
        if(car.getCarPosition().getPosition() > maxPosition){
            takeTheLead(car);
            this.maxPosition = car.getCarPosition().getPosition();
        }else if(car.getCarPosition().getPosition() == maxPosition){
            winningCarList.add(car);
        }
    }

    public void takeTheLead(Car car){
        if(winningCarList.size() != 0){
            this.winningCarList = new ArrayList<>();
            winningCarList.add(car);
        }else if(winningCarList.size() == 0){
            winningCarList.add(car);
        }
    }


}
