package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final String inputCarNamesMessage = "차이름을 입력하세요.:띄워쓰기 없이 쉼표로 구분합니다.";
    private final String errorMessage = "[ERROR]: 입력이 잘못되었습니다.";

    public Game(){
    }

    public String[] inputRacingCarName(){
        String inputLine = Console.readLine();
        String[] racingCarNameList = inputLine.split(",");
        return racingCarNameList;
    }

    public boolean isValidRacingCarNameLength(String racingCarName){
        return racingCarName.length() <= 5 && racingCarName.length() > 0;
    }

    public boolean isValidRacingCarNameContainsSpace(String racingCarName){
        return !racingCarName.contains(" ");
    }

    public int isValidateCarName(String racingCarName){
        if(isValidRacingCarNameLength(racingCarName) && isValidRacingCarNameContainsSpace(racingCarName)){
            return 1;
        }
        return 0;
    }

    public boolean checkAllCarNameValidations(String[] racingCarNames){
        int count = 0;
        for(int idx = 0; idx<racingCarNames.length; idx++){
            count += isValidateCarName(racingCarNames[idx]);
        }
        if(count == racingCarNames.length){
            return true;
        }
        return false;
    }

    public void checkIllegalCarNameInputs(String[] carNameList){
        if(!checkAllCarNameValidations(carNameList)){
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int inputRepeatCount(){
        String repeatCount = Console.readLine();
        return Integer.parseInt(repeatCount);
    }

    public void printInputCarNamesMessege(){
        System.out.println(inputCarNamesMessage);
    }

    public void printEachRacingCarsPosition(RacingCars racingCars){
        for(int idx = 0; idx < racingCars.size(); idx++){
            RacingCar racingCar = racingCars.returnRacingCarAtIndex(idx);
            System.out.println(racingCar.getName() + " "+ racingCar.positionToString());
        }
    }

    public ArrayList<RacingCar> getWinners(RacingCars racingCars){
        ArrayList<RacingCar> winners = new ArrayList<RacingCar>();
        int maxPosition = 0;
        for(int idx = 0; idx < racingCars.size(); idx++){
            RacingCar racingCar = racingCars.returnRacingCarAtIndex(idx);
            maxPosition =maxPosition >= racingCar.getRacingCarPosition() ? maxPosition :racingCar.getRacingCarPosition();
        }
        for(int idx = 0; idx < racingCars.size(); idx++){
            RacingCar racingCar = racingCars.returnRacingCarAtIndex(idx);
            if(racingCar.getRacingCarPosition() == maxPosition){
                winners.add(racingCar);
            }
        }
        return winners;
    }

    public void printWinners(List<RacingCar> winners){
        String winnersList = "";
        for(int idx = 0; idx< winners.size(); idx++){
            winnersList += winners.get(idx).getName();
            winnersList += ",";
        }
        if (winners.size() == 1){
            winnersList = winnersList.substring(0, winnersList.length()-1);
        }
        System.out.println(winnersList);
    }
}
