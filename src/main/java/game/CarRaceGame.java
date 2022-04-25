package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import game.model.FinalWinner;
import game.model.RacingCars;
import game.model.CarMoveCount;

public class CarRaceGame {

    private CarMoveCount carMoveCount;
    private RacingCars car;
    private FinalWinner winner;

    public void setRacingCars(){
        while (true){
            try {
                this.car = new RacingCars(Console.readLine());
                break;
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                System.out.println("[ERROR] 자동차 이름은 1자 이상 5자 이하 여야한다.");
            }
        }
    }

    public void setCarMoveCount(){
        while (true) {
            try {
                this.carMoveCount = new CarMoveCount(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
    }

    public void start(){
        System.out.println("실행 결과");
        for(int i=0; i<carMoveCount.getCarMoveCount(); i++ ){
            racingStart();
            resultPrint();
        }
        winner = new FinalWinner(car.getCar());
        winner.printWinner();
    }

    private void racingStart(){
        for(String carName : car.getCar().keySet()){
            advanceOrStop(carName);
        }

    }

    private void advanceOrStop(String carName){
        if(Randoms.pickNumberInRange(0,9) >3 ){
            car.getCar().put(carName,car.getCar().get(carName)+1);
        }
    }

    private void resultPrint(){
        for(String carName : car.getCar().keySet()){
            System.out.println(carName+" : "+gameEmceeResult(carName));
        }
        System.out.println();
    }

    private String gameEmceeResult(String carName){
        String result = "";
        for(int i=0; i<car.getCar().get(carName); i++){
            result += "-";
        }
        return result;
    }

}
