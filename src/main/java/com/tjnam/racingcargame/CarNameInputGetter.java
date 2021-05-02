package com.tjnam.racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarNameInputGetter {
    private static Scanner carNameScanner = new Scanner(System.in);
    private String userInput;

    public List<CarName> getCarNameInput(){
        String userInput = inputCarNames();
        String[] carNamesStr = splitUserInput(userInput);
        List<CarName> carNames = convertStringToCarName(carNamesStr);
        return carNames;
    }

    private String inputCarNames(){
        String userInput = carNameScanner.nextLine();
        if (userInput.length() == 0) {
            throw new IllegalArgumentException("NO_USER_INPUT");
        }
        return userInput;
    }

    private String[] splitUserInput(String userInput){
        if (userInput.length() == 0) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return userInput.split(",");
    }

    private List<CarName> convertStringToCarName(String[] carNameInputs){
        List<CarName> carNames = new ArrayList<CarName>();
        for (String carNameInput : carNameInputs) {
            carNames.add(new CarName(carNameInput));
        }
        return carNames;
    }
}
