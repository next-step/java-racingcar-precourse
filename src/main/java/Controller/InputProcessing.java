package Controller;

import View.RacingViews;
import Model.FindErrors;

public class InputProcessing {
    public String getValidCarNames() {
        while(true){
            try{
                RacingViews racingViews = new RacingViews();
                FindErrors findErrors = new FindErrors();
                String carNames = racingViews.getCarNames();
                findErrors.validCarNames(carNames);
                return carNames;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
