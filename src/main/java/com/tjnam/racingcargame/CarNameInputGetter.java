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
        return userInput;
    }

    private Boolean validateUserInput(String userInput){
        return true;
    }

    private String[] splitUserInput(String userInput){
        return userInput.split(",");
    }

    private List<CarName> convertStringToCarName(String[] carNameInputs){
        List<CarName> carNames = new ArrayList<CarName>();
        for (int i=0 ; i<carNameInputs.length ; i++) {
            carNames.add(new CarName(carNameInputs[i]));
        }
        return carNames;
    }
}
