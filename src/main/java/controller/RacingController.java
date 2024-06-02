package controller;

import model.Race;
import utils.InputValidation;
import view.RacingView;

public class RacingController {
    public void startRacing(){
        Race race;
        race = inputCarName();
        race.setTryNum(inputTryNum());
        RacingView.printResultmessage();
        for(int i = 0;i<race.getTryNum();i++){
            race.moveCarByRandNum(race.getCarlist());
            RacingView.moveStatus(race.getCarlist());
        }
        RacingView.printResult(race.getWinner());
    }
    public Race inputCarName(){
        while(true){
            try{
                String inputCars = RacingView.printInputCarName();
                String[] carNames = inputCars.split(",");
                InputValidation.isValidInput(carNames);//유효성검사
                Race race = new Race(carNames);
                return race;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
    public int inputTryNum(){
        while(true){
            try{
                String inputTryNum = RacingView.printInputTryNum();
                InputValidation.isNumber(inputTryNum); //정수인지 확인
                int newtryNum = Integer.parseInt(inputTryNum);
                return newtryNum;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]"+e.getMessage());
            }
        }
    }
}
