package com.tjnam.racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarNameInputGetter {

    private static Scanner carNameScanner = new Scanner(System.in);

    public List<CarName> getCarNameInput(){
        String userInput;
        printGetCarNameGuideMessages();
        do {
            userInput = inputCarNames();
        } while(isValidateUserInput(userInput) == false);
        String[] carNamesStr = splitUserInput(userInput);
        List<CarName> carNames = convertStringToCarName(carNamesStr);
        return carNames;
    }

    private String inputCarNames(){
        String userInput = carNameScanner.nextLine();
        return userInput;
    }

    private boolean isValidateUserInput(String userInput){
        if (userInput.length() == 0) {
            return false;
        }
        String[] CarNames = splitUserInput(userInput);
        if (CarNames.length == 0) {
            return false;
        }
        return true;
    }

    private String[] splitUserInput(String userInput){
        return userInput.split(",");
    }

    private List<CarName> convertStringToCarName(String[] carNameInputs){
        List<CarName> carNames = new ArrayList<CarName>();
        for (String carNameInput : carNameInputs) {
            carNames.add(new CarName(carNameInput));
        }
        return carNames;
    }

    private void printGetCarNameGuideMessages(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    private void printUserInputErrorMessage(){
        System.out.println("사용자 입력이 없었습니다. 다시 자동차 이름을 입력해주세요.");
    }
}
