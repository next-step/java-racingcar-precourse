package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.*;
import racingcar.utils.inputOutputMessage;
import racingcar.utils.exceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class racingcarServiceImple implements racingcarService{
    private List<racingCar> car = new ArrayList<>();
    private racingcarMoveCount moveCount;
    private racingCars cars;
    private inputOutputMessage message = new inputOutputMessage();
    private exceptionMessage exceptionMessage = new exceptionMessage();
    private String winner = "";
    private String[] carNamesArr;
    private final int minRandomNumber = 0;
    private final int maxRandomNumber = 9;
    private final int forwardRandomNumber = 4;
    public void inputracingCarNameCheck(){
        message.inputNameMessage();
        carNamesArr = Console.readLine().split(",");
    }
    public void inputracingCarNameAdd(){
        for(String carName : carNamesArr){
            car.add(new racingCar(new racingcarName(carName)));
        }
        cars = new racingCars(car);
    }
    public void inputracingCars(){
        try{
            car = new ArrayList<>();
            inputracingCarNameCheck();
            inputracingCarNameAdd();
        }
        catch(IllegalArgumentException e){
            System.out.println(exceptionMessage.InputCarNameWrong());
            inputracingCars();
        }
    }
    public void inputracingCount(){
        try {
            message.inputCountMessage();
            moveCount = new racingcarMoveCount(Console.readLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(exceptionMessage.InputNumNegativeAndUnderZero());
            inputracingCount();
        }
    }
    public boolean createRandomnumber(){
        int randomNumber = Randoms.pickNumberInRange(minRandomNumber,maxRandomNumber);
        if(randomNumber >= forwardRandomNumber)
            return true;
        return false;
    }
    public void createRandomnumberAddListCar(List<racingCar> listCar, int idx){
        if(createRandomnumber()) {
            listCar.get(idx).getPositionClass().move();
        }
    }
    public  List<racingCar> inputracingPosition(){
       List<racingCar> listCar = cars.getCars();
       for(int i = 0 ; i<listCar.size();i++) {
           createRandomnumberAddListCar(listCar, i);
       }
       return listCar;
    }
    public int getMoveCount(){
        return Integer.parseInt(moveCount.getMoveCount());
    }
    public void racingAddWinner(int idx,int position){
        List<racingCar> listCar = cars.getCars();
        if(cars.getCars().get(idx).getPositionClass().getPosition() == position){
            winner += (listCar.get(idx).getCarNameClass().getCarName()) + ", ";
        }
    }
    public String racingWinner(){
        List<racingCar> listCar = cars.getCars();
        int MaxPosition = Integer.MIN_VALUE;
        for(int i = 0 ; i<listCar.size();i++) {
            MaxPosition = Integer.max(MaxPosition,listCar.get(i).getPositionClass().getPosition());
        }
        for(int i = 0 ; i<listCar.size();i++) {
            racingAddWinner(i,MaxPosition);
        }
        return winner.substring(0,winner.length()-2);
    }
}
